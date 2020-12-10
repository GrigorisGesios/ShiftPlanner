package com.example.shiftplanner;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

public class Week {

    private ArrayList<Day> daylist = new ArrayList<>();

    public Week(ArrayList<Day> daylist) {
        this.daylist = daylist;
    }

    public ArrayList<Day> getDaylist() {
        return daylist;
    }

    public void setDaylist(ArrayList<Day> daylist) {
        this.daylist = daylist;
    }

    private String maxDaysOff;

    public String getMaxDaysOff() {
        return maxDaysOff;
    }

    public void setMaxDaysOff(String maxDaysOff) {
        this.maxDaysOff = maxDaysOff;
    }


}
