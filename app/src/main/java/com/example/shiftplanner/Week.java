package com.example.shiftplanner;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

public class Week {

    private String maxDaysOff;

    private Day dayobj = new Day();
    private ArrayList<ArrayList<String>> list = new ArrayList<>();
    private ArrayList<ArrayList<String>> daylist = new ArrayList<>();

    public Week() throws JSONException {
    }


    public ArrayList<ArrayList<String>> createWeek() throws JSONException {
            list = dayobj.createDay();
            for(int i=0;i<7;i++)
            {
                daylist.addAll(list);
            }
        return daylist;
    }

    public String getMaxDaysOff() {
        return maxDaysOff;
    }

    public void setMaxDaysOff(String maxDaysOff) {
        this.maxDaysOff = maxDaysOff;
    }


}
