package com.example.shiftplanner;

import android.util.Log;
import android.view.View;
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

    public void returnWorkers(ArrayList<Week> lista, int day, int month, int year, TextView tv1,TextView tv2,TextView tv3,TextView tv4,TextView tv5,TextView tv6,TextView tvempty,TextView ttv1,TextView ttv2,TextView ttv3,TextView ttv4,TextView ttv5,TextView ttv6) throws JSONException {
        Calendar date = Calendar.getInstance();
        Calendar dateofalg = Calendar.getInstance();
        date.set(year,month,day,0,0); // Μέρα που πατήθηκε απο τον χρήστη
        ParseJ parseobj = new ParseJ();
        int numberofshifts = parseobj.getRestriction("ar_vard");
        ArrayList<String> workerslist1 = new ArrayList<>();
        ArrayList<String> workerslist2 = new ArrayList<>();
        ArrayList<String> workerslist3 = new ArrayList<>();
        ArrayList<String> workerslist4 = new ArrayList<>();
        ArrayList<String> workerslist5 = new ArrayList<>();
        ArrayList<String> workerslist6 = new ArrayList<>();
        StringBuilder builder1 = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        StringBuilder builder3 = new StringBuilder();
        StringBuilder builder4 = new StringBuilder();
        StringBuilder builder5 = new StringBuilder();
        StringBuilder builder6 = new StringBuilder();
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
                    //for (int j = 0; j < lista.get(k).getDaylist().get(i).getListofshifts().size(); j++) {
                        //workerslist.addAll(lista.get(i).getListofshifts().get(j).getShiftworkerslist());
                    tvempty.setVisibility(View.INVISIBLE);
                    switch(numberofshifts)
                    {
                        case 1:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            ttv1.setVisibility(View.VISIBLE);
                            tv1.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            break;
                        case 2:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            workerslist2.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(1).getShiftworkerslist());
                            ttv1.setVisibility(View.VISIBLE);
                            ttv2.setVisibility(View.VISIBLE);
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            for (String details : workerslist2) {
                                builder2.append(details + "\n");
                            }
                            tv2.setText(builder2.toString());
                            break;
                        case 3:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            workerslist2.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(1).getShiftworkerslist());
                            workerslist3.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(2).getShiftworkerslist());
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            tv3.setVisibility(View.VISIBLE);
                            ttv1.setVisibility(View.VISIBLE);
                            ttv2.setVisibility(View.VISIBLE);
                            ttv3.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            for (String details : workerslist2) {
                                builder2.append(details + "\n");
                            }
                            tv2.setText(builder2.toString());
                            for (String details : workerslist3) {
                                builder3.append(details + "\n");
                            }
                            tv3.setText(builder3.toString());
                            break;
                        case 4:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            workerslist2.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(1).getShiftworkerslist());
                            workerslist3.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(2).getShiftworkerslist());
                            workerslist4.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(3).getShiftworkerslist());
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            tv3.setVisibility(View.VISIBLE);
                            tv4.setVisibility(View.VISIBLE);
                            ttv1.setVisibility(View.VISIBLE);
                            ttv2.setVisibility(View.VISIBLE);
                            ttv3.setVisibility(View.VISIBLE);
                            ttv4.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            for (String details : workerslist2) {
                                builder2.append(details + "\n");
                            }
                            tv2.setText(builder2.toString());
                            for (String details : workerslist3) {
                                builder3.append(details + "\n");
                            }
                            tv3.setText(builder3.toString());
                            for (String details : workerslist4) {
                                builder4.append(details + "\n");
                            }
                            tv4.setText(builder4.toString());
                            break;
                        case 5:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            workerslist2.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(1).getShiftworkerslist());
                            workerslist3.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(2).getShiftworkerslist());
                            workerslist4.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(3).getShiftworkerslist());
                            workerslist5.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(4).getShiftworkerslist());
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            tv3.setVisibility(View.VISIBLE);
                            tv4.setVisibility(View.VISIBLE);
                            tv5.setVisibility(View.VISIBLE);
                            ttv1.setVisibility(View.VISIBLE);
                            ttv2.setVisibility(View.VISIBLE);
                            ttv3.setVisibility(View.VISIBLE);
                            ttv4.setVisibility(View.VISIBLE);
                            ttv5.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            for (String details : workerslist2) {
                                builder2.append(details + "\n");
                            }
                            tv2.setText(builder2.toString());
                            for (String details : workerslist3) {
                                builder3.append(details + "\n");
                            }
                            tv3.setText(builder3.toString());
                            for (String details : workerslist4) {
                                builder4.append(details + "\n");
                            }
                            tv4.setText(builder4.toString());
                            for (String details : workerslist5) {
                                builder5.append(details + "\n");
                            }
                            tv5.setText(builder5.toString());
                            break;
                        case 6:
                            workerslist1.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(0).getShiftworkerslist());
                            workerslist2.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(1).getShiftworkerslist());
                            workerslist3.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(2).getShiftworkerslist());
                            workerslist4.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(3).getShiftworkerslist());
                            workerslist5.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(4).getShiftworkerslist());
                            workerslist6.addAll(lista.get(k).getDaylist().get(i).getListofshifts().get(5).getShiftworkerslist());
                            tv1.setVisibility(View.VISIBLE);
                            tv2.setVisibility(View.VISIBLE);
                            tv3.setVisibility(View.VISIBLE);
                            tv4.setVisibility(View.VISIBLE);
                            tv5.setVisibility(View.VISIBLE);
                            tv6.setVisibility(View.VISIBLE);
                            ttv1.setVisibility(View.VISIBLE);
                            ttv2.setVisibility(View.VISIBLE);
                            ttv3.setVisibility(View.VISIBLE);
                            ttv4.setVisibility(View.VISIBLE);
                            ttv5.setVisibility(View.VISIBLE);
                            ttv6.setVisibility(View.VISIBLE);
                            for (String details : workerslist1) {
                                builder1.append(details + "\n");
                            }
                            tv1.setText(builder1.toString());
                            for (String details : workerslist2) {
                                builder2.append(details + "\n");
                            }
                            tv2.setText(builder2.toString());
                            for (String details : workerslist3) {
                                builder3.append(details + "\n");
                            }
                            tv3.setText(builder3.toString());
                            for (String details : workerslist4) {
                                builder4.append(details + "\n");
                            }
                            tv4.setText(builder4.toString());
                            for (String details : workerslist5) {
                                builder5.append(details + "\n");
                            }
                            tv5.setText(builder5.toString());
                            for (String details : workerslist6) {
                                builder6.append(details + "\n");
                            }
                            tv6.setText(builder6.toString());
                            break;
                        default:
                            break;
                    }
                    //}
                }
                else
                {
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                    ttv1.setVisibility(View.INVISIBLE);
                    ttv2.setVisibility(View.INVISIBLE);
                    ttv3.setVisibility(View.INVISIBLE);
                    ttv4.setVisibility(View.INVISIBLE);
                    ttv5.setVisibility(View.INVISIBLE);
                    ttv6.setVisibility(View.INVISIBLE);
                    tvempty.setVisibility(View.VISIBLE);
                    tvempty.setText("ΑΡΓΙΑ");
                }
                finished = true;
                found = true;
            }
            if(i == sizeofDaylist-1)
            {
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
                    tv1.setVisibility(View.INVISIBLE);
                    tv2.setVisibility(View.INVISIBLE);
                    tv3.setVisibility(View.INVISIBLE);
                    tv4.setVisibility(View.INVISIBLE);
                    tv5.setVisibility(View.INVISIBLE);
                    tv6.setVisibility(View.INVISIBLE);
                    ttv1.setVisibility(View.INVISIBLE);
                    ttv2.setVisibility(View.INVISIBLE);
                    ttv3.setVisibility(View.INVISIBLE);
                    ttv4.setVisibility(View.INVISIBLE);
                    ttv5.setVisibility(View.INVISIBLE);
                    ttv6.setVisibility(View.INVISIBLE);
                    tvempty.setVisibility(View.VISIBLE);
                    tvempty.setText("Μη εργάσιμη μέρα.");
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
