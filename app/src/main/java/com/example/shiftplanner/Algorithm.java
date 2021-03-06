package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import static com.example.shiftplanner.Manager.GiveRestrictions.ischanged;
import static com.example.shiftplanner.Manager.GiveRestrictions.mera;
import static com.example.shiftplanner.Manager.GiveRestrictions.minas;
import static com.example.shiftplanner.Manager.GiveRestrictions.textD;
import static com.example.shiftplanner.Manager.GiveRestrictions.textS;
import static com.example.shiftplanner.Manager.GiveRestrictions.textW;
import static com.example.shiftplanner.Manager.GiveRestrictions.xronos;

public class Algorithm
{
    public static ParseJ parseobj = new ParseJ();
    public static ArrayList<Workers> masterworkerslist;

    static {
        try {
            masterworkerslist = parseobj.parseWorkers2();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    Calendar date = Calendar.getInstance();
    int numofweeks = 0;
    int numberofshifts = 0;
    int numberofdays = 0;
    int date_year = 0;
    int date_month = 0;
    int date_day   = 0;
    int v1 = parseobj.getRestriction("vardia1");
    int v2 = parseobj.getRestriction("vardia2");
    int v3 = parseobj.getRestriction("vardia3");
    int v4 = parseobj.getRestriction("vardia4");
    int v5 = parseobj.getRestriction("vardia5");
    int v6 = parseobj.getRestriction("vardia6");

    public Algorithm() throws JSONException {
    }

    public ArrayList<Day> createWeek() throws JSONException {
        ArrayList<Workers> dayworkerslist = new ArrayList<>();
        //numberofshifts = parseobj.getRestriction("ar_vard");
        //numberofdays = parseobj.getRestriction("ar_days");
        int maximumhoursperweek = parseobj.getRestriction("wres_evd");
        int workhours = parseobj.getRestriction("sun_wres");
        TruthTable table[] = new TruthTable[masterworkerslist.size()];   //Πίνακας αληθείας
        ArrayList<String> idlist = new ArrayList<>();   //Λίστα με τα ID των εργαζομένων

        ArrayList<Day> daylist = new ArrayList<>();
        ArrayList<Workers> currentshift = new ArrayList<>();

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
        for(int i=0;i<numberofdays;i++)  //Γίνονται οι ανάλογες μέρες σύμφωνα με τον περιορισμό
        {
            dayworkerslist = checkDayRequirements(date.get(Calendar.DAY_OF_WEEK)); //Δημιουργεί μέρα με τα requirements των εργαζομένων
            ArrayList<Shift> shiftlista = new ArrayList<>();
            boolean holidaycheck = false;
            holidaycheck = checkForHoliday(date);
            if (!holidaycheck)
            {
                for (int j = 1; j < numberofshifts + 1; j++) //Έλεγχος για κάθε βάρδια
                {
                    int numberofworkers = checkShift(j);
                    int k = 0;
                    while (!(currentshift.size() == numberofworkers)) //Έλεγχος μίας βάρδιας
                    {
                        Workers obj = dayworkerslist.get(k);
                        String wid = obj.getWorkersID();
                        int index = idlist.indexOf(wid);
                        if (table[index].isInsertedin() == false && (Integer.parseInt(table[index].getWorker().getVardiaO()) != j) && table[index].getTotalhoursworked() < maximumhoursperweek) {
                            currentshift.add(obj); //Βάζει τον εργαζόμενο στην βάρδια
                            table[index].setInsertedin(true); //Κάνε τον εργαζόμενο μη διαθέσιμο για την επόμενη βάρδια
                            table[index].addToTotalHoursWorked(workhours); //Προσθέτει τις ώρες που εργάστηκε
                            k++;
                        } else {
                            //skip to next
                            k++;
                        }
                    }
                    Shift shiftobj = new Shift();
                    //parsecurrentshift = changeToString(currentshift);
                    //currentshift1.clear();
                    ArrayList<Workers> parsecurrentshift = new ArrayList<>();
                    parsecurrentshift.addAll(currentshift);
                    Log.d("68PleaseWork", String.valueOf(parsecurrentshift.size()));
                    //shiftobj.setShiftworkerslist(parsecurrentshift);
                    shiftobj.setShiftworkerslist(parsecurrentshift);
                    shiftlista.add(shiftobj);
                    currentshift.clear();
                }
          }
            else
            {
                //skip
            }
          for(int p=0;p<table.length;p++)  //Κάνει τους εργαζομένους διαθέσιμους για την επόμενη μέρα.
          {
              table[p].setInsertedin(false);
          }
            Day dobj = new Day(shiftlista,date.getTime(),holidaycheck);
            daylist.add(dobj);
            date.add(Calendar.DAY_OF_MONTH,1);
        }
        Log.d("SHIFTSIZE1:", String.valueOf(daylist.get(0).getListofshifts().get(0).getShiftworkerslist().size()));
       return daylist;
    }
    //Τέλος αλγορίθμου

    public ArrayList<Week> createSchedule() throws JSONException {
        ArrayList<Week> finallist = new ArrayList<>();
        if(ischanged)
        {
            numofweeks = Integer.parseInt(textW);
            numberofshifts = Integer.parseInt(textS);
            numberofdays = Integer.parseInt(textD);
            date_year = Integer.parseInt(xronos);
            date_month = Integer.parseInt(minas);
            date_day   = Integer.parseInt(mera);
        }
        else if(!ischanged)
        {
             numofweeks = parseobj.getRestriction("ar_week");
             numberofshifts = parseobj.getRestriction("ar_vard");
             numberofdays = parseobj.getRestriction("ar_days");
             date_year = parseobj.getRestriction("d_year");
             date_month = parseobj.getMonth();
             date_day   = parseobj.getRestriction("d_day");
        }
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

    public boolean checkForHoliday(Calendar date)
    {
        boolean isHoliday = false;
        if(date.get(Calendar.MONTH)==0 && date.get(Calendar.DAY_OF_MONTH)==1)
        {
            isHoliday =true;
        }
        else if(date.get(Calendar.MONTH)==11 && date.get(Calendar.DAY_OF_MONTH)==25)
        {
            isHoliday =true;
        }
        else if(date.get(Calendar.MONTH)==11 && date.get(Calendar.DAY_OF_MONTH)==26)
        {
            isHoliday =true;
        }
        else
        {
            isHoliday = false;
        }
        return isHoliday;
    }

    public ArrayList<Workers> checkDayRequirements(int daynumber)
    {
        ArrayList<Workers> list = new ArrayList<>();

        for(int i=0;i<masterworkerslist.size();i++)
        {
            if(!(returnDayToInteger(masterworkerslist.get(i).getMeraO()) == daynumber))
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

    public int returnDayToInteger(String dayname)
    {
        int day = 0;
        if(dayname.equals("Deutera"))
        {
            day = 2;
        }
        else if(dayname.equals("Trith"))
        {
            day=3;
        }
        else if(dayname.equals("Tetarth"))
        {
            day=4;
        }
        else if(dayname.equals("Pempth"))
        {
            day=5;
        }
        else if(dayname.equals("Paraskeuh"))
        {
            day=6;
        }
        else if(dayname.equals("Sabbato"))
        {
            day=7;
        }
        else if(dayname.equals("Kyriakh"))
        {
            day=1;
        }
        return day;
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
}

