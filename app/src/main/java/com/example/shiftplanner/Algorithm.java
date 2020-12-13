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

    int mornworkers = parseobj.getRestriction("prwi_pros");
    int afternoonworkers = parseobj.getRestriction("apogeuma_pros");
    int nightworkers = parseobj.getRestriction("vradu_pros");

    public Algorithm() throws JSONException {
    }

    public ArrayList<ArrayList<String>> createWeek() throws JSONException {   //Αυτη η μέθοδος δουλεύι κανονικά
        ArrayList<Workers> dayworkerslist = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<String>> finallist = new ArrayList<>();
        ArrayList<Workers> shiftlist = new ArrayList<>();
        int numberofshifts = parseobj.getRestriction("ar_vard");
        int maximumhoursperweek = parseobj.getRestriction("wres_evd");
        int workhours = parseobj.getRestriction("sun_wres");
        TruthTable table[] = new TruthTable[masterworkerslist.size()];   //Πίνακας αληθείας
        ArrayList<String> idlist = new ArrayList<>();   //Λίστα με τα ID των εργαζομένων


        for(int t=0;t<masterworkerslist.size();t++) //Μπαίνουν τα id στην idlist
        {
            idlist.add(masterworkerslist.get(t).getWorkersID());
        }

        for(int o=0;o<masterworkerslist.size();o++) //Μπαίνουν οι εργαζόμενοι στον πίνακα αληθείας
        {
              Workers obj = masterworkerslist.get(o);
              table[o] = new TruthTable(obj);
        }

        //Αλγόριθμος
        for(int i=1;i<8;i++)  //Γίνονται 7 μέρες
        {
            dayworkerslist = checkDayRequirements(i); //Δημιουργεί μέρα με τα requirements των εργαζομένων

            for(int j=1;j<numberofshifts+1;j++) //Έλεγχος για κάθε βάρδια
            {
                 int numberofworkers = checkShift(j);
                 int k=0;
                 while(!(shiftlist.size() == numberofworkers)) //Έλεγχος μίας βάρδιας
                 {
                     Workers obj = dayworkerslist.get(k);
                     String wid = obj.getWorkersID();
                     int index = idlist.indexOf(wid);
                     if(table[index].isInsertedin() == false && (Integer.parseInt(table[index].getWorker().getVardiaO()) != j) && table[index].getTotalhoursworked() < maximumhoursperweek)
                      {
                        shiftlist.add(obj); //Βάζει τον εργαζόμενο στην βάρδια
                        table[index].setInsertedin(true); //Κάνε τον εργαζόμενο μη διαθέσιμο για την επόμενη βάρδια
                        table[index].addToTotalHoursWorked(workhours); //Προσθέτει τις ώρες που εργάστηκε
                        k++;
                      }
                    else
                      {
                        //skip to next
                        k++;
                      }
                 }
                 list = changeToString(shiftlist);
                 finallist.add(list);
                 shiftlist.clear();
            }

          for(int p=0;p<table.length;p++)  //Κάνει τους εργαζομένους διαθέσιμους για την επόμενη μέρα.
          {
              table[p].setInsertedin(false);
          }
          for(int ar=0;ar<table.length;ar++)
          {
              Log.d("Ergazomenos:",table[ar].getWorker().getFirstName() + "WresErgasias:" + String.valueOf(table[ar].getTotalhoursworked()));
          }
        }
       return finallist;
    }
    //Τέλος αλγορίθμου
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

