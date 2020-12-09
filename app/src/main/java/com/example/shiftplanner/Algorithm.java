package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

public class Algorithm
{
    ParseJ parseobj = new ParseJ();
    ArrayList<Workers> masterworkerslist = parseobj.parseWorkers();

    ArrayList<Shift> shiftlist = new ArrayList<>();

    ArrayList<ArrayList<String>> dailyshiftlist = new ArrayList<>();

    int mornworkers = parseobj.getRestriction("prwi_pros");
    int afternoonworkers = parseobj.getRestriction("apogeuma_pros");
    int nightworkers = parseobj.getRestriction("vradu_pros");

    public Algorithm() throws JSONException {
    }

    public ArrayList<Workers> createShift(ArrayList<Workers> list,int shift) throws JSONException {

        ArrayList<Workers> lista = new ArrayList<>();
        lista=checkShiftRequirements(list,shift);
        return lista;
    }

    public ArrayList<ArrayList<String>> createDay(ArrayList<Workers> workerslist) throws JSONException {

        ArrayList<ArrayList<String>> finaldaylist = new ArrayList<>();
        int shiftnum = parseobj.getRestriction("ar_vard");
        for(int i=1;i<shiftnum+1;i++)
        {
            finaldaylist.add(changeToString(createShift(workerslist,i)));
        }
       return finaldaylist;//δενεπιστρέφει αυτό
    }

    public ArrayList<ArrayList<ArrayList<String>>> createWeek() throws JSONException {
        ArrayList<Workers> dayworkerslist = new ArrayList<>();
        ArrayList<ArrayList<ArrayList<String>>> finalweeklist= new ArrayList<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
       //έλεγχος για το πόσες μέρες θέλουμε!!!
        for(int i=1;i<8;i++)
        {
            dayworkerslist = checkDayRequirements(i);    //ΙΣΩΣ αυτό αποτελέσει πρόβλημα στο μέλλον,μπορεί να μην περνιούνται όλα τ α δεδομένα
            finalweeklist.add(createDay(dayworkerslist));
        }
       return finalweeklist;
    }

    public ArrayList<Workers> checkDayRequirements(int daynumber)
    {
        ArrayList<Workers> list = new ArrayList<>();

        for(int i=0;i<masterworkerslist.size();i++)
        {
            if(!(Integer.parseInt(masterworkerslist.get(i).getMeraO()) == daynumber))
            {
                list.add(masterworkerslist.get(i));
            }
            else
            {
               //Do nothing
            }
        }
        return list;
    }

    public ArrayList<Workers> checkShiftRequirements(ArrayList<Workers> lista,int shiftnumber)
    {
        ArrayList<Workers> list = new ArrayList<>();
        int currentshift = shiftnumber;
        int numberofworkers;
        numberofworkers = checkShift(shiftnumber); //ΔΟΥΛΕΥΕΙ ΚΑΝΟΝΙΚΑ
        ArrayList<Workers> templist = new ArrayList<>();
        int i=0;
        while(!(templist.size() == numberofworkers))
        {
            Workers obj = lista.get(i);
            if(lista.contains(obj))
            {
                i++;
            }
            else
            {
                if(Integer.parseInt(lista.get(i).getVardiaO()) != shiftnumber)
                {
                    list.add(obj);
                    templist.add(obj);
                }
                else
                {
                    i++;
                }
            }
        }

        for(int j=0;j<list.size();j++)
        {
            Log.d("metalistameras:",list.get(j).getFirstName());
        }
        return templist;
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

    public ArrayList<String> changeToString(ArrayList<Workers> lista) throws JSONException {

        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<lista.size();i++)
        {
            String workerfname = lista.get(i).getFirstName();
            String workerlname = lista.get(i).getLastName();
            String workerid = lista.get(i).getWorkersID();
            String workerprof = lista.get(i).getWorkersProf();
            String oneworker = workerid + " " + workerfname +" "+ workerlname +" "+ workerprof;
            list.add(oneworker);
        }
        return list;
    }
}
