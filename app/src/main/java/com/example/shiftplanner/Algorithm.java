package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Algorithm
{
    ParseJ parseobj = new ParseJ();
    ArrayList<Workers> masterworkerslist = parseobj.parseWorkers();
    Calendar date = Calendar.getInstance();
    int numofweeks = parseobj.getRestriction("ar_week");
    int date_year = parseobj.getRestriction("d_year");
    int date_month = parseobj.getRestriction("d_month");
    int date_day   = parseobj.getRestriction("d_day");
    int v1 = parseobj.getRestriction("vardia1");
    int v2 = parseobj.getRestriction("vardia2");
    int v3 = parseobj.getRestriction("vardia3");
    int v4 = parseobj.getRestriction("vardia4");
    int v5 = parseobj.getRestriction("vardia5");
    int v6 = parseobj.getRestriction("vardia6");

    public Algorithm() throws JSONException {
    }

    public ArrayList<Day> createWeek() throws JSONException {
        /*date.set(Calendar.YEAR,date_year);
        date.set(Calendar.MONTH,date_month);
        date.set(Calendar.DAY_OF_MONTH,date_day);*/

        //date.set(date_year,date_month,date_day,0,0);

        ArrayList<Workers> dayworkerslist = new ArrayList<>();
        int numberofshifts = parseobj.getRestriction("ar_vard");
        int numberofdays = parseobj.getRestriction("ar_days");
        int maximumhoursperweek = parseobj.getRestriction("wres_evd");
        int workhours = parseobj.getRestriction("sun_wres");
        TruthTable table[] = new TruthTable[masterworkerslist.size()];   //Πίνακας αληθείας
        ArrayList<String> idlist = new ArrayList<>();   //Λίστα με τα ID των εργαζομένων

        ArrayList<Day> daylist = new ArrayList<>();
        ArrayList<Workers> currentshift = new ArrayList<>();
        ArrayList<String> parsecurrentshift = new ArrayList<>();

        Collections.shuffle(masterworkerslist);
        Log.d("TOTALCHECK:", String.valueOf(masterworkerslist.size()));
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
        for(int i=1;i<numberofdays+1;i++)  //Γίνονται οι ανάλογες μέρες σύμφωνα με τον περιορισμό
        {
            dayworkerslist = checkDayRequirements(i); //Δημιουργεί μέρα με τα requirements των εργαζομένων
            ArrayList<Shift> shiftlista = new ArrayList<>();
            for(int j=1;j<numberofshifts+1;j++) //Έλεγχος για κάθε βάρδια
            {
                 int numberofworkers = checkShift(j);
                 int k=0;
                 while(!(currentshift.size() == numberofworkers)) //Έλεγχος μίας βάρδιας
                 {
                     Workers obj = dayworkerslist.get(k);
                     String wid = obj.getWorkersID();
                     int index = idlist.indexOf(wid);
                     if(table[index].isInsertedin() == false && (Integer.parseInt(table[index].getWorker().getVardiaO()) != j) && table[index].getTotalhoursworked() < maximumhoursperweek)
                      {
                        currentshift.add(obj); //Βάζει τον εργαζόμενο στην βάρδια
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
                Shift shiftobj = new Shift();
                parsecurrentshift = changeToString(currentshift);
                Log.d("68PleaseWork", String.valueOf(parsecurrentshift.size()));
                shiftobj.setShiftworkerslist(parsecurrentshift);
                shiftlista.add(shiftobj);
                //Log.d("69PleaseWork", String.valueOf(shiftlista.get(0).getShiftworkerslist().get(0)));
                currentshift.clear();
                //Log.d("70PleaseWork", String.valueOf(shiftlista.get(0).getShiftworkerslist().get(0)));

                ///ΠΑΛΙΑ,ΔΕΝ ΘΕΛΟΥΝ ΑΛΛΑΓΕΣ
                 //list = changeToString(currentshift);
                 //finallist.add(list);
                ///ΠΑΛΙΑ,ΔΕΝ ΘΕΛΟΥΝ ΑΛΛΑΓΕΣ
            }
          //Log.d("3PleaseWork",shiftlista.get(0).getShiftworkerslist().get(0));
          for(int p=0;p<table.length;p++)  //Κάνει τους εργαζομένους διαθέσιμους για την επόμενη μέρα.
          {
              table[p].setInsertedin(false);
          }
            Day dobj = new Day(shiftlista,date.getTime());
            daylist.add(dobj);
            Log.d("71PleaseWork",daylist.get(0).getListofshifts().get(0).getShiftworkerslist().get(0));
            date.add(Calendar.DAY_OF_MONTH,1);
        }
       return daylist;
    }
    //Τέλος αλγορίθμου

    public ArrayList<Week> createSchedule() throws JSONException {
        ArrayList<Week> finallist = new ArrayList<>();
        for(int i=0;i<numofweeks;i++)
        {
            date.set(date_year,date_month,date_day,0,0);
            Log.d("AlgTime1:", String.valueOf(date.getTime()));
            date.add(Calendar.DAY_OF_MONTH,7*i);
            Log.d("AlgTime2:", String.valueOf(date.getTime()));
            ArrayList<Day> weeklist = new ArrayList<>();
            weeklist = createWeek();
            Week obj = new Week(weeklist,date.getTime());
            finallist.add(obj);
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

    public int checkShift(int x)
    {
        switch (x)
        {
            case 1:
                x=v1;
                break;
            case 2:
                x=v2;
                break;
            case 3:
                x=v3;
                break;
            case 4:
                x=v4;
                break;
            case 5:
                x=v5;
                break;
            case 6:
                x=v6;
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
            String oneworker = workerid + " " + workerfname +" "+ workerlname;
            list.add(oneworker);
        }
        return list;
    }

    /*public boolean isWorkerIn()
    {

    }*/
}

