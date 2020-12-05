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
    private Day dayobj = new Day();
    private Week wobj = new Week();

    public Schedule() throws JSONException {
    }


    public void printSchedule(TextView scheduleview) throws JSONException {

        StringBuilder builder = new StringBuilder();

            schedule= wobj.createWeek();

        for(ArrayList<String> details : schedule)
        {
            builder.append(details + "\n");
        }
         scheduleview.setText(builder.toString());
    }
}
