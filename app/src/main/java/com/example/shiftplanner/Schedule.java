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
    private Algorithm alg = new Algorithm();

    public Schedule() throws JSONException {
    }


    public void printSchedule(TextView scheduleview) throws JSONException {

        StringBuilder builder = new StringBuilder();

            schedule= alg.createWeek();

        for(ArrayList<String> details : schedule)
        {
            builder.append(details + "\n");
        }
         scheduleview.setText(builder.toString());
    }
}
