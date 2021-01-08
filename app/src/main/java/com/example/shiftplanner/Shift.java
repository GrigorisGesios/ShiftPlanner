package com.example.shiftplanner;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Shift {

    private Context context;

    String shiftStaff;
    String shiftTime;

    ArrayList<Workers> dailyworkerslist = new ArrayList<Workers>();
    ArrayList<String>  dailyworkersstringlist = new ArrayList<String>();


    ParseJ parseobj = new ParseJ();

    public Shift() {
    }

    public Shift(Context context) {
        this.context = context;
    }


    public ArrayList<String> changeToString() throws JSONException {

        ArrayList<String> list = new ArrayList<String>();
        dailyworkerslist = parseobj.parseWorkers();
        for(int i=0;i<dailyworkerslist.size();i++)
        {
            String workerfname = dailyworkerslist.get(i).getFirstName();
            String workerlname = dailyworkerslist.get(i).getLastName();
            String workerid = dailyworkerslist.get(i).getID();
            String workerprof = dailyworkerslist.get(i).getWorkersProf();
            String oneworker = workerid + " " + workerfname +" "+ workerlname +" "+ workerprof;
            list.add(oneworker);
        }
        return list;
    }

    public ArrayList<String> setWorkersOnShift() throws JSONException {
        dailyworkersstringlist = changeToString();
        ArrayList<String> list = new ArrayList<>();

        int totlaworkers = parseobj.getRestriction("sunol_pros"); //getRestrition παράδειγμα

        for(int i=0;i<totlaworkers;i++)
        {
            list.add(String.valueOf(dailyworkersstringlist.get(i)));
        }
        return list;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getShiftStaff() {
        return shiftStaff;
    }

    public void setShiftStaff(String shiftStaff) {
        this.shiftStaff = shiftStaff;
    }

}
