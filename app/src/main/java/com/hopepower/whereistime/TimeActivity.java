package com.hopepower.whereistime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.hopepower.whereistime.Adapter.TimeAdapter;
import com.hopepower.whereistime.Bean.TimeBean;
import com.hopepower.whereistime.Model.Date;
import com.hopepower.whereistime.Model.Time;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TimeActivity extends AppCompatActivity {

    ListView screenTimeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Date date = (Date) getIntent().getSerializableExtra("save_date");
        screenTimeList = (ListView) findViewById(R.id.screen_time_list);
        List<TimeBean> timeBeanList = new ArrayList<TimeBean>();
        for (Time time: date.getTimeList()) {
            timeBeanList.add(TimeToTimeBean(time));
        }
        screenTimeList.setAdapter(new TimeAdapter(this, timeBeanList));
    }

    private TimeBean TimeToTimeBean (Time time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        TimeBean timeBean = new TimeBean();
        timeBean.setOnScreenTime(simpleDateFormat.format(time.getOnScreenTime()));
        if (time.getOffScreenTime() != null) {
            timeBean.setOffScreenTime(simpleDateFormat.format(time.getOffScreenTime()));
            timeBean.setAllScreenTime(String.valueOf((time.getOffScreenTime().getTime() - time.getOnScreenTime().getTime()) / 1000));
        } else {
            timeBean.setOffScreenTime("  ");
            timeBean.setAllScreenTime("  ");
        }

        return timeBean;
    }
}
