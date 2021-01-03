package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Week {

    private ArrayList<Day> daylist = new ArrayList<>();

    public Week(ArrayList<Day> daylist) {
        this.daylist = daylist;
    }

    public ArrayList<Day> getDaylist() {
        return daylist;
    }

    public void setDaylist(ArrayList<Day> daylist) {
        this.daylist = daylist;
    }

    private String maxDaysOff;

    public String getMaxDaysOff() {
        return maxDaysOff;
    }

    public void setMaxDaysOff(String maxDaysOff) {
        this.maxDaysOff = maxDaysOff;
    }


    public ArrayList<String> returnWorkers(ArrayList<Day> lista, int day, int month, int year, TextView tvw) throws JSONException {
        Calendar date = Calendar.getInstance();
        Calendar dateofalg = Calendar.getInstance();
        date.set(year,month,day,0,0); // Μέρα που πατήθηκε απο τον χρήστη
        Log.d("1CHECKTIME:", String.valueOf(date.getTime()));
        ArrayList<String> workerslist = new ArrayList<>();
        int sizeoflista = lista.size();
        Boolean found = false;
        Boolean finished = false;
        int i=0;
        while(!finished) {
            Date currentdate = lista.get(i).getDateofday(); //Μέρα του αλγορίθμου
            dateofalg.setTime(currentdate);
            //Log.d("2CHECKTIME:", String.valueOf(currentdate));
            //Log.d("3CHECKTIME:", String.valueOf(date.get(Calendar.YEAR) == dateofalg.get(Calendar.YEAR)));

            if (( date.get(Calendar.YEAR) == dateofalg.get(Calendar.YEAR)) && (date.get(Calendar.MONTH) == dateofalg.get(Calendar.MONTH)) && (date.get(Calendar.DAY_OF_MONTH) == dateofalg.get(Calendar.DAY_OF_MONTH))) {
                for (int j = 0; j < lista.get(i).getListofshifts().size(); j++) {
                    workerslist.addAll(lista.get(i).getListofshifts().get(j).getShiftworkerslist());
                }
                StringBuilder builder = new StringBuilder();
                for (String details : workerslist) {
                    builder.append(details + "\n");
                }
                tvw.setText(builder.toString());
                finished = true;
                found = true;
            }
            i++;
            if(i == sizeoflista)
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
       return workerslist;
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


}
