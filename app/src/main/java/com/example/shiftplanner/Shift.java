package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Shift {

    private ArrayList<Workers> shiftworkerslist = new ArrayList<>();

    String shiftTime;

    public Shift(ArrayList<Workers> shiftworkerslist) {
        this.shiftworkerslist = shiftworkerslist;
    }

    public ArrayList<Workers> getShiftworkerslist() {
        return shiftworkerslist;
    }


    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

}
