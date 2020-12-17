package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Day {

      private ArrayList<Shift> shiftlist = new ArrayList<>();

      public Day(ArrayList<Shift> shiftlist) {
        this.shiftlist = shiftlist;
      }

    public ArrayList<Shift> getShiftlist() {
        return shiftlist;
    }

    public void setShiftlist(ArrayList<Shift> shiftlist) {
        this.shiftlist = shiftlist;
    }
}






