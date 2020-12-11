package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Algorithm
{
    ParseJ parseobj = new ParseJ();
    ArrayList<Workers> masterworkerslist = parseobj.parseWorkers();

    //ArrayList<Shift> shiftlist = new ArrayList<>();

    ArrayList<ArrayList<String>> dailyshiftlist = new ArrayList<>();

    int mornworkers = parseobj.getRestriction("prwi_pros");
    int afternoonworkers = parseobj.getRestriction("apogeuma_pros");
    int nightworkers = parseobj.getRestriction("vradu_pros");

    public Algorithm() throws JSONException {
    }

    public void createDay(ArrayList<Workers> workerslist) throws JSONException {

    }

    public ArrayList<ArrayList<String>> createWeek() throws JSONException {   //Αυτη η μέθοδος δουλεύι κανονικά
        ArrayList<Workers> dayworkerslist = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> finallist = new ArrayList<>();
        ArrayList<Workers> shiftlist = new ArrayList<>();
        int numberofshifts = parseobj.getRestriction("ar_vard");
        int maximumhoursperweek = parseobj.getRestriction("wres_evd");
        int workhours = parseobj.getRestriction("sun_wres");
        TruthTable table[] = new TruthTable[masterworkerslist.size()];
        ArrayList<String> idlist = new ArrayList<>();


        for(int t=0;t<masterworkerslist.size();t++)
        {
            idlist.add(masterworkerslist.get(t).getWorkersID());
        }

        for(int o=0;o<masterworkerslist.size();o++)
        {
              Workers obj = masterworkerslist.get(o);
              table[o] = new TruthTable(obj);
        }
        //Log.d("MYARRAY:","arr" + Arrays.toString(table));

        for(int i=1;i<8;i++)
        {
            dayworkerslist = checkDayRequirements(i);

            for(int j=1;j<numberofshifts+1;j++)
            {
                //list = changeToString(addToShift(dayworkerslist,j));
                 int numberofworkers = checkShift(j);
                 int k=0;
                 while(!(shiftlist.size() == numberofworkers))
                 {
                     Workers obj = dayworkerslist.get(k);
                     String wid = obj.getWorkersID();//ΔΟΥΛΕΥΕΙ
                     int index = idlist.indexOf(wid);
                     Log.d("29INDEX:", String.valueOf(index));;
                    if(table[index].isInsertedin() == false && (Integer.parseInt(table[index].getWorker().getVardiaO()) != j) && table[index].getTotalhoursworked() < maximumhoursperweek)
                    {
                        shiftlist.add(obj);
                        table[index].setInsertedin(true);

                        table[index].addToTotalHoursWorked(workhours);
                        Log.d("ERGAZOMENOS:",table[index].getWorker().getLastName());
                        Log.d("WRES:",String.valueOf(table[index].getTotalhoursworked()));
                        k++;
                    }
                    else
                    {
                        //do nothing
                        k++;
                    }
                 }
                 list = changeToString(shiftlist);
                 finallist.add(list);
                 shiftlist.clear();
            }

          for(int p=0;p<table.length;p++)
          {
              table[p].setInsertedin(false);
          }
        }
       return finallist;
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

    /*public ArrayList<Workers> testAdd(ArrayList<Workers> daylist,int shiftnumber)
    {
        int numberofworkers = checkShift(shiftnumber);
        boolean test = true;
        while(!(shiftlist.size() == numberofworkers))
        {
            Log.d("INTEGER:",String.valueOf(numberofworkers));
            Workers obj = daylist.get(0);
            //Log.d("INTEGER:",String.valueOf(table[k].isInsertedin()));
            if(test)
            {
                shiftlist.add(obj);
                //shiftlist.add(dayworkerslist.get(k));
                //table[k].setInsertedin(true);
                k++;
            }
            else
            {
                //do nothing
                k++;
            }
        }
        list = changeToString(addToShift(dayworkerslist,j));
        finallist.add(list);
    }*/
    public ArrayList<Workers> addToShift(ArrayList<Workers> daylist,int shiftnumber)
    {
        int numberofworkers = checkShift(shiftnumber);
        ArrayList<Workers> lista = new ArrayList<>();

        for(int i=0;i<numberofworkers;i++)
        {
            lista.add(daylist.get(i));
        }
        return lista;
    }
    public ArrayList<Workers> checkShiftRequirements(ArrayList<Workers> lista,int shiftnumber)
    {
        int numberofshifts=3;   //Αυτό πρέπει να γίνεται αυτόματα
        int numberofworkers;
        ArrayList<Workers> list = new ArrayList<>();
        int shift = checkShift(shiftnumber);

        for(int i=0;i<shift;i++)
        {
            if(!(Integer.parseInt(lista.get(i).getVardiaO()) == shiftnumber))
            {
                list.add(lista.get(i));
            }
            else
            {
                //Do nothing
            }
        }

        return list;
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

