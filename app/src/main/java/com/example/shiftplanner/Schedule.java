package com.example.shiftplanner;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.shiftplanner.ParseJ.loadJSONFromAsset;

public class Schedule
{
    private ArrayList<ArrayList<String>> schedule = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> schedule1 = new ArrayList<>();
    private Algorithm alg = new Algorithm();

    public Schedule() throws JSONException {
    }


    public void printSchedule(TextView scheduleview) throws JSONException {
        ParseJ parseobj = new ParseJ();
        int numberofweeks = parseobj.getRestriction("ar_week");

    public void printSchedule(TextView scheduleview,ArrayList<String> list) throws JSONException {


        //ParseJ parseobj = new ParseJ();
        //int numberofweeks = parseobj.getRestriction("ar_week");
        StringBuilder builder = new StringBuilder();
           for(int i=0;i<numberofweeks;i++)
           {
               schedule= alg.createWeek();
               schedule1.add(schedule);
           }

<<<<<<< Updated upstream

        for(ArrayList<ArrayList<String>> details : schedule1)
=======
        //for(int i=0;i<numberofweeks;i++)
        //{
           // schedule= alg.createWeek();
            schedule1.add(schedule);
        //}

        for(String details : list)
>>>>>>> Stashed changes
        {
            builder.append(details + "\n");
        }
         scheduleview.setText(builder.toString());
    }
}
