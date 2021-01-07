package com.example.shiftplanner;


import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;

import static com.example.shiftplanner.Algorithm.masterworkerslist;

public class ToUI
{
    //ParseJ parseobj = new ParseJ();
    //ArrayList<Workers> wlist = parseobj.parseWorkers();

    public ToUI() throws JSONException {
    }


    public void viewRequirements(TextView t1)
    {
        String nonwantedshift = new String();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<masterworkerslist.size();i++)
        {
            nonwantedshift = returnShift(Integer.parseInt(masterworkerslist.get(i).getVardiaO()));
            list.add(masterworkerslist.get(i).getWorkersID() + "   " +masterworkerslist.get(i).getLastName() + "   "+ masterworkerslist.get(i).getMeraO() + "   " + nonwantedshift);
        }

        StringBuilder builder = new StringBuilder();

        for(String details : list)
        {
            builder.append(details + "\n");
        }
        t1.setText(builder.toString());
    }

    private String returnShift(int shiftnumber)
    {
        String shift = new String();
                switch(shiftnumber)
                {
                    case 1:
                        shift = "1η βάρδια";
                        break;
                    case 2:
                        shift = "2η βάρδια";
                        break;
                    case 3:
                        shift = "3η βάρδια";
                        break;
                    default:
                        break;
                }
                return shift;
    }
    private String returnDay(int daynumber)
    {
        String day = new String();
        switch(daynumber)
        {
            case 1:
                day = "Δευτέρα";
                break;
            case 2:
                day = "Τρίτη";
                break;
            case 3:
                day = "Τετάρτη";
                break;
            case 4:
                day = "Πέμπτη";
                break;
            case 5:
                day = "Παρασκευή";
                break;
            case 6:
                day = "Σάββατο";
                break;
            case 7:
                day = "Κυριακή";
                break;
            default:
                day = null;
                break;
        }
        return day;
    }

}
