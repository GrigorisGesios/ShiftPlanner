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
    private ArrayList<String> schedule = new ArrayList<String>();
    private Shift shiftobj = new Shift();

    public Schedule() throws JSONException {
    }


    public void printSchedule(TextView scheduleview) throws JSONException {

        StringBuilder builder = new StringBuilder();

            schedule=shiftobj.changeToString();

        for(String details : schedule)
        {
            builder.append(details + "\n");
        }
         scheduleview.setText(builder.toString());
    }
}
