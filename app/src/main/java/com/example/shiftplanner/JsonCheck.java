package com.example.shiftplanner;

import android.util.Log;

import org.json.JSONException;

import java.util.ArrayList;

public class JsonCheck
{
    ParseJ parseobj = new ParseJ();
    int numberofemployees = parseobj.getRestriction("sunol_pros");
    int numberofdailyemployees = parseobj.getRestriction("sunol_pros_hmeras");
    int totalhours = parseobj.getRestriction("sun_wres");
    int totalshifts =  parseobj.getRestriction("ar_vard");
    int v1 = parseobj.getRestriction("vardia1");



    public JsonCheck() throws JSONException {
    }

    public boolean checkIfTimeIsCorrect()
    {
        boolean isCorrect = false;

        if(totalhours*totalshifts>24)
        {
            isCorrect = false;
        }
        else
        {
            isCorrect = true;
        }
        return isCorrect;
    }

    public boolean checkWorkerCount()
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

}
