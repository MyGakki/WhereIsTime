package com.hopepower.whereistime.Model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12531 on 2017/5/18.
 */

public class Date extends DataSupport implements Serializable {

    private java.util.Date saveDate;

    private List<Time> timeList = new ArrayList<Time>();

    public List<Time> getTimeList() {
        return timeList;
    }

    public void setTimeList(List<Time> timeList) {
        this.timeList = timeList;
    }

    public java.util.Date getSaveDate() {
        return saveDate;
    }

    public void setSaveDate(java.util.Date saveDate) {
        this.saveDate = saveDate;
    }
}
