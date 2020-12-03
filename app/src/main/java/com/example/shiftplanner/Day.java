package com.example.shiftplanner;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Day {

    private Context context;

    private Shift shiftobj = new Shift();

    ArrayList<ArrayList<String>> dailyshiftlist = new ArrayList<>();

    public Day() throws JSONException {
    }

    public ArrayList<ArrayList<String>> DailyShifts() throws JSONException {
            dailyshiftlist.add(shiftobj.setWorkersOnShift());
        return dailyshiftlist;
    }

}






