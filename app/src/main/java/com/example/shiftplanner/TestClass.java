package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

public class TestClass {

    ParseJ parseobj = new ParseJ();
    ArrayList<Workers> masterworkerslist = parseobj.parseWorkers();

    ArrayList<Workers> wlist = new ArrayList<>();
    ArrayList<Shift> slist = new ArrayList<>();
    ArrayList<Day> dlist = new ArrayList<>();

    Workers wobj = new Workers();

    public TestClass() throws JSONException {
    }

    public void testMethod()
    {
        /*for(int t=0;t<5;t++)
        {
            int y=t;
            while(y != 4)
            {
                wlist.add(masterworkerslist.get(y));
                y++;
            }
            Shift sobj = new Shift();
            sobj.setShiftworkerslist(wlist);
            slist.add(sobj);
            //Log.d("1TestClass:",slist.get(1).getShiftworkerslist().get(5).getWorkersID());
           // wlist.clear();
        }*/

    }
}
