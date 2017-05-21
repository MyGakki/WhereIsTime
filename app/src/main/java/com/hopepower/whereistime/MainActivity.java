package com.hopepower.whereistime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hopepower.whereistime.Model.Date;
import com.hopepower.whereistime.Service.TimeService;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.litepal.crud.DataSupport.findAll;

public class MainActivity extends AppCompatActivity {

    private ListView lv_dateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_dateInfo = (ListView) findViewById(R.id.lv_dateInfo);
        LitePal.getDatabase();
        boolean isStore = false;
        java.util.Date currentDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<Date> dates = findAll(Date.class);
        for (Date date: dates) {
            if (simpleDateFormat.format(date.getSaveDate()).toString().equals(simpleDateFormat.format(currentDate).toString())) {
                isStore = true;
                break;
            }
        }
        if (isStore == false) {
            Date date = new Date();
            date.setSaveDate(currentDate);
            date.save();
        }
        Intent startIntent = new Intent(this, TimeService.class);
        startService(startIntent);
        final List<Date> dateList = DataSupport.order("saveDate desc").find(Date.class,true);
        final List<String> dateInfoList = new ArrayList<String>();
        for (Date date: dateList) {
            dateInfoList.add(simpleDateFormat.format(date.getSaveDate()));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,dateInfoList);
        lv_dateInfo.setAdapter(arrayAdapter);
        lv_dateInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Date date = dateList.get(i);
                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                intent.putExtra("save_date",date);
                startActivity(intent);
            }
        });
    }
}
