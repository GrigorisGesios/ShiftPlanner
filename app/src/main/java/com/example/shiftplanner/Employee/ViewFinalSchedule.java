package com.example.shiftplanner.Employee;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.Manager.ManagerLayout;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.util.ArrayList;

import static com.example.shiftplanner.Manager.ChooseData.weekslist;
import static com.example.shiftplanner.Manager.ManagerLayout.schedulecreated;


public class ViewFinalSchedule extends AppCompatActivity {


    public ViewFinalSchedule() throws JSONException {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);

        if(!schedulecreated)
        {
            String message = "Δεν έχει δημιουργηθεί πρόγραμμα απο τον manager!";
            Toast.makeText(ViewFinalSchedule.this,message,Toast.LENGTH_SHORT).show();
        }
        else
        {
            CalendarView cv = findViewById(R.id.schedulecalendar);
            TextView ttv1 = findViewById(R.id.Text_V1);
            TextView ttv2 = findViewById(R.id.Text_V2);
            TextView ttv3 = findViewById(R.id.Text_V3);
            TextView ttv4 = findViewById(R.id.Text_V4);
            TextView ttv5 = findViewById(R.id.Text_V5);
            TextView ttv6 = findViewById(R.id.Text_V6);
            TextView tv1 = findViewById(R.id.Vardia1);
            TextView tv2 = findViewById(R.id.Vardia2);
            TextView tv3 = findViewById(R.id.Vardia3);
            TextView tv4 = findViewById(R.id.Vardia4);
            TextView tv5 = findViewById(R.id.Vardia5);
            TextView tv6 = findViewById(R.id.Vardia6);
            TextView tvempty = findViewById(R.id.No_Vardia);
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
        }
    }
}