package com.hopepower.whereistime.Bean;

/**
 * Created by 12531 on 2017/5/19.
 */

public class TimeBean {

    private String onScreenTime;

    private String offScreenTime;

    private String allScreenTime;

    public TimeBean() {
    }

    public TimeBean(String onScreenTime, String offScreenTime, String allScreenTime) {
        this.onScreenTime = onScreenTime;
        this.offScreenTime = offScreenTime;
        this.allScreenTime = allScreenTime;
    }

    public String getOnScreenTime() {
        return onScreenTime;
    }

    public void setOnScreenTime(String onScreenTime) {
        this.onScreenTime = onScreenTime;
    }

    public String getOffScreenTime() {
        return offScreenTime;
    }

    public void setOffScreenTime(String offScreenTime) {
        this.offScreenTime = offScreenTime;
    }

    public String getAllScreenTime() {
        return allScreenTime;
    }

    public void setAllScreenTime(String allScreenTime) {
        this.allScreenTime = allScreenTime;
    }
}
