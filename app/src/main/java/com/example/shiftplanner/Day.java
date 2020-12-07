package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Integer.parseInt;

public class Day {

    ParseJ parseobj = new ParseJ();
    ArrayList<Workers> worklist = parseobj.parseWorkers();

    ArrayList<Shift> shiftlist = new ArrayList<>();

    ArrayList<ArrayList<String>> dailyshiftlist = new ArrayList<>();

    int mornworkers = parseobj.getRestriction("prwi_pros");
    int afternoonworkers = parseobj.getRestriction("apogeuma_pros");
    int nightworkers = parseobj.getRestriction("vradu_pros");

    public Day() throws JSONException {
    }

    public Shift checkShift(ArrayList<Workers> list, int shiftnum)
    {
        int currentshift = shiftnum;
        int numberofworkers;
        numberofworkers = checkShift(shiftnum);
        ArrayList<Workers> templist = new ArrayList<>();
        int i=0;
        while(!(templist.size() == numberofworkers)) {
            Workers obj = worklist.get(i);
            String vardiaO = obj.getVardiaO();
            int vardiao = Integer.parseInt(vardiaO);
            //Log.d("WORKGET:",obj.getFirstName());
            if (list.contains(obj)) {
                i++;
            } else {
                if (vardiao != currentshift) {
                    list.add(obj);
                    templist.add(obj);
                } else {
                    i++;
                }
            }
        }
        Shift shift = new Shift(templist);
        return shift;
    }

    public ArrayList<Shift> setShiftList() throws JSONException {

        ArrayList<Workers> wlist = new ArrayList<>();

        Shift shift1 = checkShift(wlist, 1);
        shiftlist.add(shift1);

        Shift shift2 = checkShift(wlist, 2);
        shiftlist.add(shift2);

        Shift shift3 = checkShift(wlist, 3);
        shiftlist.add(shift3);

        return shiftlist;
    }

    public ArrayList<String> changeToString(ArrayList<Shift> lista,int arithmos) throws JSONException {

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Workers> listw = new ArrayList<>();
        listw = lista.get(arithmos).getShiftworkerslist();
        for(int i=0;i<listw.size();i++)
        {
            String workerfname = listw.get(i).getFirstName();
            String workerlname = listw.get(i).getLastName();
            String workerid = listw.get(i).getWorkersID();
            String workerprof = listw.get(i).getWorkersProf();
            String oneworker = workerid + " " + workerfname +" "+ workerlname +" "+ workerprof;
            list.add(oneworker);
        }
        return list;
    }

    public ArrayList<ArrayList<String>> createDay() throws JSONException {

         ArrayList<String> daylist = new ArrayList<>();
         setShiftList();
         daylist = changeToString(shiftlist,0);
         dailyshiftlist.add(daylist);
         daylist = changeToString(shiftlist,1);
         dailyshiftlist.add(daylist);
         daylist = changeToString(shiftlist,2);
         dailyshiftlist.add(daylist);
         return dailyshiftlist;
    }

    public int checkShift(int x)
    {
        switch (x)
        {
            case 1:
                x=mornworkers;
                break;
            case 2:
                x=afternoonworkers;
                break;
            case 3:
                x=nightworkers;
                break;
            default:
                break;
        }
        return x;
    }

}






