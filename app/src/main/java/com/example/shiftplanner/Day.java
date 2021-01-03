package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class Day {

    private ArrayList<Shift> listofshifts = new ArrayList<>();
    private Date dateofday = null;

    public Day(ArrayList<Shift> listofshifts, Date dateofday) {
        this.listofshifts = listofshifts;
        this.dateofday = dateofday;
    }

    public ArrayList<Shift> getListofshifts() {
        return listofshifts;
    }

    public void setListofshifts(ArrayList<Shift> listofshifts) {
        this.listofshifts = listofshifts;
    }

    public Date getDateofday() {
        return dateofday;
    }

    public void setDateofday(Date dateofday) {
        this.dateofday = dateofday;
    }

}






