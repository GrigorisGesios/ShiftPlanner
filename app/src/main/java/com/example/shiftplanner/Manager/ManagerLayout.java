package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.Employee.DaysOff;
import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.JsonCheck;
import com.example.shiftplanner.MainActivity;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.util.ArrayList;

public class ManagerLayout extends AppCompatActivity {

    Button btnGiveRestrictions,btnReviewRequirements,btnPlanFinalSchedule,btnHireEmployee,btnFireEmployee, btnViewFinalSchedule;
    public static boolean schedulecreated = false;
    private Algorithm algobj = new Algorithm();

    public ManagerLayout() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_layout);

        btnGiveRestrictions = (Button) findViewById(R.id.btnGiveRestrictions);
        btnReviewRequirements = (Button) findViewById(R.id.btnReviewRequirements);
        btnPlanFinalSchedule = (Button) findViewById(R.id.btnPlanFinalSchedule);
        btnHireEmployee = (Button) findViewById(R.id.btnHireEmployee);
        btnFireEmployee = (Button) findViewById(R.id.btnFireEmployee);
        btnViewFinalSchedule = (Button) findViewById(R.id.btnViewFinalSchedule2);

        btnGiveRestrictions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLayout.this, GiveRestrictions.class);
                startActivity(intent);
            }
        });

        btnReviewRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLayout.this, ReviewRequirements.class);
                startActivity(intent);
            }
        });

        btnPlanFinalSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(schedulecreated)
                {
                    String message = null;
                    message = "Υπάρχει ήδη πρόγραμμα εργασιών. Πατήστε το κουμπί \"View Final Schedule\" για να το δείτε.";
                    Toast.makeText(ManagerLayout.this,message,Toast.LENGTH_LONG).show();
                }
                else if(!schedulecreated)
                {
                    Intent intent = new Intent(ManagerLayout.this, ChooseData.class);
                    startActivity(intent);
                }
            }
        });

        btnHireEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLayout.this, HireEmployee.class);
                startActivity(intent);
            }
        });

        btnFireEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLayout.this, FireEmployee.class);
                startActivity(intent);
            }
        });

       btnViewFinalSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!schedulecreated)
                {
                    Context context = getApplicationContext();
                    CharSequence errortext = "";
                    errortext = "Δεν έχει δημιουργηθεί κάποιο πρόγραμμα εργασιών.";
                    int duration = Toast.LENGTH_LONG;
                    Toast jsonerrortoast = Toast.makeText(context,errortext,duration);
                    jsonerrortoast.show();
                    Intent intent = new Intent(ManagerLayout.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(schedulecreated)
                {
                    Intent intent = new Intent(ManagerLayout.this, ViewFinalSchedule.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        super.onBackPressed();

    }
}