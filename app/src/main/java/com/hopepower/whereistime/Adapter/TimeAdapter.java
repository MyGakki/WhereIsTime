package com.hopepower.whereistime.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hopepower.whereistime.Bean.TimeBean;
import com.hopepower.whereistime.R;

import java.util.List;

/**
 * Created by 12531 on 2017/5/19.
 */

public class TimeAdapter extends BaseAdapter {

    private List<TimeBean> timeBeanList;

    private LayoutInflater layoutInflater;

    public TimeAdapter(Context context, List<TimeBean> timeBeanList) {
        this.timeBeanList = timeBeanList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return timeBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return timeBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.item_time,null);
            viewHolder.onScreenTimeTv = (TextView) view.findViewById(R.id.on_screen_time_tv);
            viewHolder.offScreenTimeTv = (TextView) view.findViewById(R.id.off_screen_time_tv);
            viewHolder.allScreenTimeTv = (TextView) view.findViewById(R.id.all_screen_time_tv);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        TimeBean timeBean = timeBeanList.get(i);
        viewHolder.onScreenTimeTv.setText(timeBean.getOnScreenTime());
        viewHolder.offScreenTimeTv.setText(timeBean.getOffScreenTime());
        viewHolder.allScreenTimeTv.setText(timeBean.getAllScreenTime() + "s");
        return view;
    }

    class ViewHolder {
        public TextView onScreenTimeTv;
        public TextView offScreenTimeTv;
        public TextView allScreenTimeTv;
    }
}
