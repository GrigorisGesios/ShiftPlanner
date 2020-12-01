package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

public class Week {

    private Context weekcontext = ParseJ.getParsecontext();
    private String maxDaysOff;

    private Day dayobj = new Day();
    private ArrayList<String> listofweeks = new ArrayList<String>();

    public Week() throws JSONException {
    }


    public ArrayList<String> createWeek() throws JSONException {
            listofweeks = dayobj.DailyShifts();
        return listofweeks;
    }

    public String getMaxDaysOff() {
        return maxDaysOff;
    }

    public void setMaxDaysOff(String maxDaysOff) {
        this.maxDaysOff = maxDaysOff;
    }


}
