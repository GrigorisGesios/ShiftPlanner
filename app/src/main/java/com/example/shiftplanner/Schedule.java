package com.example.shiftplanner;

import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.shiftplanner.ParseJ.loadJSONFromAsset;

public class Schedule
{
    private ArrayList<ArrayList<String>> schedule = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> schedule1 = new ArrayList<>();
    private Algorithm alg = new Algorithm();

    public Schedule() throws JSONException {
    }

    public void returnWorkers(ArrayList<Week> lista, int day, int month, int year, TextView tvw) throws JSONException {
        Calendar date = Calendar.getInstance();
        Calendar dateofalg = Calendar.getInstance();
        date.set(year,month,day,0,0); // Μέρα που πατήθηκε απο τον χρήστη
        Log.d("1CHECKTIME:", String.valueOf(date.getTime()));
        ArrayList<String> workerslist = new ArrayList<>();
        int sizeoflista = lista.size();
        int sizeofDaylist = lista.get(0).getDaylist().size();
        Boolean found = false;
        Boolean finished = false;
        int i=0;
        int k=0;
        while(!finished) {
            Date currentdate = lista.get(k).getDaylist().get(i).getDateofday();  //Μέρα του αλγορίθμου
            dateofalg.setTime(currentdate);
            //Log.d("2CHECKTIME:", String.valueOf(currentdate));
            //Log.d("3CHECKTIME:", String.valueOf(date.get(Calendar.YEAR) == dateofalg.get(Calendar.YEAR)));

            if (( date.get(Calendar.YEAR) == dateofalg.get(Calendar.YEAR)) && (date.get(Calendar.MONTH) == dateofalg.get(Calendar.MONTH)) && (date.get(Calendar.DAY_OF_MONTH) == dateofalg.get(Calendar.DAY_OF_MONTH))) {
                if(lista.get(k).getDaylist().get(i).getHoliday() == false)
                {
                    for (int j = 0; j < lista.get(k).getDaylist().get(i).getListofshifts().size(); j++) {
                        //workerslist.addAll(lista.get(i).getListofshifts().get(j).getShiftworkerslist());
                        workerslist.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(j).getShiftworkerslist());
                    }
                    StringBuilder builder = new StringBuilder();
                    for (String details : workerslist) {
                        builder.append(details + "\n");
                    }
                    tvw.setText(builder.toString());
                }
                else
                {
                    tvw.setText("ΑΡΓΙΑ");
                }
                finished = true;
                found = true;
            }
            if(i == sizeofDaylist-1)
            {
                Log.d("ELEXOS",String.valueOf(k));
                k++;
                i=0;
            }
            else
            {
                i++;
            }
            if(k == sizeoflista)
            {
                finished = true;
                if(found)
                {
                    //βγες απο την while
                }
                else if(!found)
                {
                    tvw.setText("Μη εργάσιμη μέρα.");
                }
            }
        }
    }

    public void printSchedule(TextView scheduleview,ArrayList<String> list) throws JSONException {

        //ParseJ parseobj = new ParseJ();
        //int numberofweeks = parseobj.getRestriction("ar_week");
        StringBuilder builder = new StringBuilder();

        //for(int i=0;i<numberofweeks;i++)
        //{
        // schedule= alg.createWeek();
        schedule1.add(schedule);
        //}

        for(String details : list)
        {
            builder.append(details + "\n");
        }
        scheduleview.setText(builder.toString());
    }
}
