package com.example.shiftplanner.Manager;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.util.ArrayList;

public class ViewFinalSchedule extends AppCompatActivity {

    public static ArrayList<Week> weekslist = new ArrayList<Week>();
    private Algorithm obj = new Algorithm();
    public static boolean schedulecreated = false;
    public ViewFinalSchedule() throws JSONException {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);
        try {
            if(!schedulecreated)
            {
                weekslist = obj.createSchedule();
                schedulecreated = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CalendarView cv = (CalendarView) findViewById(R.id.schedulecalendar);
        TextView ttv1 = (TextView) findViewById(R.id.Text_V1);
        TextView ttv2 = (TextView) findViewById(R.id.Text_V2);
        TextView ttv3 = (TextView) findViewById(R.id.Text_V3);
        TextView ttv4 = (TextView) findViewById(R.id.Text_V4);
        TextView ttv5 = (TextView) findViewById(R.id.Text_V5);
        TextView ttv6 = (TextView) findViewById(R.id.Text_V6);
        TextView tv1 = (TextView) findViewById(R.id.Vardia1);
        TextView tv2 = (TextView) findViewById(R.id.Vardia2);
        TextView tv3 = (TextView) findViewById(R.id.Vardia3);
        TextView tv4 = (TextView) findViewById(R.id.Vardia4);
        TextView tv5 = (TextView) findViewById(R.id.Vardia5);
        TextView tv6 = (TextView) findViewById(R.id.Vardia6);
        TextView tvempty = (TextView) findViewById(R.id.No_Vardia);
        tvempty.setVisibility(View.INVISIBLE);
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


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                try {
                    Schedule scheduleobj  = new Schedule();
                    scheduleobj.returnWorkers(weekslist,dayOfMonth,month,year,tv1,tv2,tv3,tv4,tv5,tv6,tvempty,ttv1,ttv2,ttv3,ttv4,ttv5,ttv6);
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