package com.example.shiftplanner.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.util.ArrayList;


public class ViewFinalSchedule extends AppCompatActivity {

    private ArrayList<Week> weekslist = new ArrayList<Week>();
    private Algorithm obj = new Algorithm();
    public boolean schedulecreated = false;
    public ViewFinalSchedule() throws JSONException {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);
        Log.d("SCHETRUE:", String.valueOf(schedulecreated));
        try {
            if(!schedulecreated)
            {
                weekslist = obj.createSchedule();
                schedulecreated = true;
                Log.d("SCHETRUE:", String.valueOf(schedulecreated));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CalendarView cv = (CalendarView) findViewById(R.id.schedulecalendar);
        TextView tv1 = (TextView) findViewById(R.id.Vardia1);
        TextView tv2 = (TextView) findViewById(R.id.Vardia2);
        TextView tv3 = (TextView) findViewById(R.id.Vardia3);
        TextView tv4 = (TextView) findViewById(R.id.Vardia4);
        TextView tv5 = (TextView) findViewById(R.id.Vardia5);
        TextView tv6 = (TextView) findViewById(R.id.Vardia6);
        tv1.setText(" ");
        tv2.setText(" ");
        tv3.setText(" ");
        tv4.setText(" ");
        tv5.setText(" ");
        tv6.setText(" ");


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                try {
                    Schedule scheduleobj  = new Schedule();
                    scheduleobj.returnWorkers(weekslist,dayOfMonth,month,year,tv1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

        /*cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                ArrayList<ArrayList<String>> lista = new ArrayList<>();
                try {
                    Algorithm obj = new Algorithm();
                    lista = obj.createWeek();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String date = (month + 1) + "/" + dayOfMonth + "/" + year;
                textView2.setText((CharSequence) lista.get(0).get(0));
            }
        });*/

        /*try {
            Schedule scheduleobj = new Schedule();
            scheduleobj.printSchedule(textView1);
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}