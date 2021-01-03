package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class Shift {

    private ArrayList<String> shiftworkerslist = new ArrayList<>();

   /* public Shift(ArrayList<String> shiftworkerslist) {
        this.shiftworkerslist = shiftworkerslist;
    }*/

    public void setShiftworkerslist(ArrayList<String> shiftworkerslist) {
        this.shiftworkerslist = shiftworkerslist;
    }

    public ArrayList<String> getShiftworkerslist() {
        return shiftworkerslist;
    }



}
