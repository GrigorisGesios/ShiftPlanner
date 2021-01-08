package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;

public class JsonCheck
{
    ParseJ parseobj = new ParseJ();
    int numberofemployees = parseobj.getRestriction("sunol_pros");
    int numberofdailyemployees = parseobj.getRestriction("sunol_pros_hmeras");
    int totalhours = parseobj.getRestriction("sun_wres");
    int totalshifts =  parseobj.getRestriction("ar_vard");
    int numberofdays = parseobj.getRestriction("ar_days");
    int totalhoursperweek = parseobj.getRestriction("wres_evd");

    int date_year = parseobj.getRestriction("d_year");
    int date_month = parseobj.getMonth();
    int date_day   = parseobj.getRestriction("d_day");

    public JsonCheck() throws JSONException {
    }

    public boolean checkIfTimeIsCorrect() //Ελέγχει αν οι περιορισμοί ξεπερνούν το 24ωρο
    {
        boolean isCorrect = false;

        if(totalhours*totalshifts>24 && totalhours<=0)
        {
            isCorrect = false;
        }
        else
        {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean checkWorkerCount() //Ελέγχει αν οι υπάλληλοι είναι αρκετοί
    {
        boolean isCorrect = false;
        Log.d("DAILY1:", String.valueOf(numberofdailyemployees));
        Log.d("DAILY2:", String.valueOf(numberofemployees));
        if(numberofdailyemployees>numberofemployees)
        {
            isCorrect = false;
        }
        else
        {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean checkIfWeekIsValid() // Ελέγχει αν οι μέρες είναι απο 1 εως 7
    {
        boolean isCorrect = false;
        if(numberofdays>0 && numberofdays<=7)
        {
            isCorrect = true;
        }
        else
        {
            isCorrect = false;
        }
        return  isCorrect;
    }

    public boolean checkIfShiftCountIsValid()
    {
        boolean isCorrect = false;
        if(totalshifts > 0 && totalshifts <=6)
        {
            isCorrect = true;
        }
        else
        {
            isCorrect = false;
        }
        return  isCorrect;
    }

    public boolean checkIfWeeklyWorkHoursAreValid()
    {
        boolean isCorrect = false;
        if(totalhoursperweek >0)
        {
            isCorrect = true;
        }
        else
        {
            isCorrect = false;
        }
        return  isCorrect;
    }

    public boolean checkIfDaysAreCorrectInWeek()
    {
        Calendar date = Calendar.getInstance();
        boolean isCorrect = false;
        date.set(date_year,date_month,date_day,0,0);
        int dayofweek = date.get(Calendar.DAY_OF_MONTH);
        switch (dayofweek)
        {
            case 1:
                if(numberofdays>0 && numberofdays<7)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 2:
                if(numberofdays>0 && numberofdays<6)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 3:
                if(numberofdays>0 && numberofdays<5)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 4:
                if(numberofdays>0 && numberofdays<4)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 5:
                if(numberofdays>0 && numberofdays<3)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 6:
                if(numberofdays>0 && numberofdays<2)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            case 7:
                if(numberofdays>0 && numberofdays<1)
                {
                    isCorrect=true;
                }
                else
                {
                    isCorrect =false;
                }
                break;
            default:
                break;
        }
        return isCorrect;
    }

}
