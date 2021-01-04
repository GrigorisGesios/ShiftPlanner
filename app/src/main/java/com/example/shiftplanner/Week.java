package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Week {

    private ArrayList<Day> daylist = new ArrayList<>();
    private Date dateofweek = null;

    public Week(ArrayList<Day> daylist,Date dateofweek) {
        this.daylist = daylist;
        this.dateofweek = dateofweek;
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


    public ArrayList<String> changeToString(ArrayList<Workers> lista) throws JSONException {

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<lista.size();i++)
        {
            String workerfname = lista.get(i).getFirstName();
            String workerlname = lista.get(i).getLastName();
            String workerid = lista.get(i).getWorkersID();
            String workerprof = lista.get(i).getWorkersProf();
            String oneworker = workerid + " " + workerfname +" "+ workerlname;
            list.add(oneworker);
        }
        return list;
    }


}
