package com.example.shiftplanner;

import android.content.Context;
import android.service.restrictions.RestrictionsReceiver;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.shiftplanner.ParseJ.loadJSONFromAsset;
import static com.example.shiftplanner.ParseJ.workerslist;
import static java.lang.Integer.parseInt;

public class Shift {

    private Context context;


    String typeOfShift;
    String shiftStaff;
    String shiftTime;   //Δεν το χρησιμοποιήσα για την ώρα
    int morningstaff = 0;
    int afternoonstaff=0;
    int nightstaff= 0;
    boolean isfull = false;
    ArrayList<Restrictions> restrictionslist = new ArrayList<Restrictions>();
    ArrayList<Workers> dailyworkerslist = new ArrayList<Workers>();
    ArrayList<String>  dailyworkersstringlist = new ArrayList<String>();


    ParseJ parseobj = new ParseJ();
    Workers workersobj = new Workers();
    Restrictions restrobj = new Restrictions();



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
            String workerid = dailyworkerslist.get(i).getWorkersID();
            String workerprof = dailyworkerslist.get(i).getWorkersProf();
            String oneworker = workerid + " " + workerfname +" "+ workerlname +" "+ workerprof;
            list.add(oneworker);
        }
        return list;

    }
    public ArrayList<String> setWorkersOnShift() throws JSONException {
        dailyworkersstringlist = changeToString();
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<7;i++)
        {
            list.add(String.valueOf(dailyworkerslist.get(i)));
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
