package com.hopepower.whereistime.Model;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by 12531 on 2017/5/19.
 */

public class Time extends DataSupport implements Serializable {

    private java.util.Date onScreenTime;

    private java.util.Date offScreenTime;

    private Date date;

    public java.util.Date getOnScreenTime() {
        return onScreenTime;
    }

    public void setOnScreenTime(java.util.Date onScreenTime) {
        this.onScreenTime = onScreenTime;
    }

    public java.util.Date getOffScreenTime() {
        return offScreenTime;
    }

    public void setOffScreenTime(java.util.Date offScreenTime) {
        this.offScreenTime = offScreenTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
