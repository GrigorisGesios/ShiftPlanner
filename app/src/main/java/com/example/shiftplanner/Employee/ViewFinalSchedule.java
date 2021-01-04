package com.example.shiftplanner.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.Day;
import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Shift;
import com.example.shiftplanner.ToUI;
import com.example.shiftplanner.Week;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ViewFinalSchedule extends AppCompatActivity {

    private ArrayList<Week> weekslist = new ArrayList<Week>();
    private Algorithm obj = new Algorithm();

    public ViewFinalSchedule() throws JSONException {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);

        try {
            weekslist = obj.createSchedule();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        CalendarView cv = (CalendarView) findViewById(R.id.schedulecalendar);
        TextView textView1 = (TextView) findViewById(R.id.EmployerView);
        TextView textView2 = (TextView) findViewById(R.id.workerview);

        textView1.setVisibility(View.INVISIBLE);
        textView2.setText(" ");


        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {

                try {

                    Schedule scheduleobj  = new Schedule();
                    scheduleobj.returnWorkers(weekslist,dayOfMonth,month,year,textView2);
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