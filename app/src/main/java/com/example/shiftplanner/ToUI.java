package com.example.shiftplanner;


import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;

public class ToUI
{
    private Context uiContext = ParseJ.getParsecontext();

    public ToUI(Context uiContext)
    {
        this.uiContext = uiContext;
    }

    //Εδώ θα μπούν μέθοδοι τύπου ShowEmployers()
    ParseJ emplist = new ParseJ(uiContext);
    ParseJ worklist = new ParseJ(uiContext);


    public void ShowSchedule(TextView tView) throws JSONException
    {
        ArrayList<Employers> list = emplist.getEmplist();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getFirstName());
            sb.append(" ");
            sb.append(list.get(i).getEmployerProff());
            sb.append(" ");
            sb.append(list.get(i).getEmployerID());
            sb.append(" ");
            sb.append(list.get(i).getLastName());
            sb.append("\n");
        }
        //Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }

    public void ShowWorkers(TextView tView) throws JSONException
    {
        ArrayList<Workers> list = worklist.getWorkerslist();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getFirstName());
            sb.append(" ");
            sb.append(list.get(i).getWorkersProf());
            sb.append(" ");
            sb.append(list.get(i).getID());
            sb.append(" ");
            sb.append(list.get(i).getLastName());
            sb.append("\n");
        }
        Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }

}
