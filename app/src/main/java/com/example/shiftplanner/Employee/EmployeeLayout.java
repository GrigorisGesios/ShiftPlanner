package com.example.shiftplanner.Employee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shiftplanner.JsonCheck;
import com.example.shiftplanner.MainActivity;
import com.example.shiftplanner.Manager.HireEmployee;
import com.example.shiftplanner.Manager.ManagerLayout;
import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;

import org.json.JSONException;

import static com.example.shiftplanner.Algorithm.parseobj;
import static com.example.shiftplanner.Manager.ManagerLayout.schedulecreated;

public class EmployeeLayout extends AppCompatActivity {

    public static boolean enteredid = false;
    public static int parseid = 0;

    Button btnGiveRequirements,btnViewFinalSchedule,btnviewdaysoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_layout);
        btnViewFinalSchedule = (Button) findViewById(R.id.btnViewFinalSchedule);
        btnGiveRequirements = (Button) findViewById(R.id.btnGiveRequirements);
        btnviewdaysoff = (Button) findViewById(R.id.days_off_btn);

        btnGiveRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmployeeLayout.this, GiveRequirements.class);
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
                    Intent intent = new Intent(EmployeeLayout.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(schedulecreated)
                {
                    Intent intent = new Intent(EmployeeLayout.this, ViewFinalSchedule.class);
                    startActivity(intent);
                }
            }
        });

        btnviewdaysoff.setOnClickListener(new View.OnClickListener() {
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
                    Intent intent = new Intent(EmployeeLayout.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(schedulecreated)
                {
                    if(!enteredid)
                    {
                        Intent intent = new Intent(EmployeeLayout.this, DaysOffID.class);
                        startActivity(intent);
                    }
                    else if(enteredid)
                    {
                        Intent intent = new Intent(EmployeeLayout.this, DaysOff.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

}