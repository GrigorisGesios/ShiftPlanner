package com.example.shiftplanner.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;

import org.json.JSONException;

public class ViewFinalSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);

        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΜΦΑΝΙΣΗ ΤΩΝ ΛΙΣΤΩΝ
        TextView textView1 = (TextView) findViewById(R.id.EmployerView);
        TextView textView2 = (TextView) findViewById(R.id.WorkersView);
        TextView textView3 = (TextView) findViewById(R.id.ReqView);

        ParseJ parsT = new ParseJ(this);
        try {
            parsT.ShowEmployers(textView1);
            parsT.ShowWorkers(textView2);
            parsT.ShowRequirements(textView3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΜΦΑΝΙΣΗ ΤΩΝ ΛΙΣΤΩΝ
    }
}