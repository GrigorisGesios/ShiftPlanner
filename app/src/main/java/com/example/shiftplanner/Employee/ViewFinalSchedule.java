package com.example.shiftplanner.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.ToUI;
import com.example.shiftplanner.Week;

import org.json.JSONException;

public class ViewFinalSchedule extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);

        Context fsContext = ParseJ.getParsecontext();

        TextView textView1 = (TextView) findViewById(R.id.EmployerView);

        ParseJ parsT = new ParseJ(fsContext);
        try {
            Schedule scheduleobj = new Schedule();
            scheduleobj.printSchedule(textView1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΜΦΑΝΙΣΗ ΤΩΝ ΛΙΣΤΩΝ
    }
}