package com.hopepower.whereistime.Service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.hopepower.whereistime.Model.Date;
import com.hopepower.whereistime.Model.Time;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;

public class TimeService extends Service {

    final static String  TAG = "HopePower";

    public TimeService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate executed ");
        IntentFilter screenFilter = new IntentFilter();
        screenFilter.addAction(Intent.ACTION_SCREEN_ON);
        screenFilter.addAction(Intent.ACTION_SCREEN_OFF);
        TimeService.this.registerReceiver(screenReceiver,screenFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date lastDate = DataSupport.findLast(Date.class);
        if (!simpleDateFormat.format(lastDate.getSaveDate()).toString().equals(simpleDateFormat.format(currentDate).toString())) {
            Date date = new Date();
            date.setSaveDate(currentDate);
            date.save();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: executed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private BroadcastReceiver screenReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Date lastDate = DataSupport.findLast(Date.class);
            if (action.equals(Intent.ACTION_SCREEN_ON)) {
                Time time = new Time();
                time.setOnScreenTime(new java.util.Date());
                time.setDate(lastDate);
                time.save();
            } else if (Intent.ACTION_SCREEN_OFF.equals(action) && DataSupport.findLast(Time.class) != null) {
                Time time = DataSupport.findLast(Time.class);
                time.setOffScreenTime(new java.util.Date());
                time.setDate(lastDate);
                time.save();
                lastDate.getTimeList().add(time);
                if (lastDate.save()) {
                    Log.d("TimeService", "成功" + lastDate.getTimeList());
                } else {
                    Toast.makeText(context, "存储失败", Toast.LENGTH_SHORT).show();
                }
                Date testDate = DataSupport.findLast(Date.class,true);
                Log.d("TimeService","test");
            } else {
            }
        }
    };
}
