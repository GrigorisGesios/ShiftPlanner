package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Employee.ViewFinalSchedule;
import com.example.shiftplanner.JsonCheck;
import com.example.shiftplanner.MainActivity;
import com.example.shiftplanner.R;

import org.json.JSONException;

public class ManagerLayout extends AppCompatActivity {

    Button btnGiveRestrictions,btnReviewRequirements,btnPlanFinalSchedule,btnHireEmployee,btnFireEmployee, btnViewFinalSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_layout);

        btnGiveRestrictions = (Button) findViewById(R.id.btnGiveRestrictions);
        btnReviewRequirements = (Button) findViewById(R.id.btnReviewRequirements);
        btnPlanFinalSchedule = (Button) findViewById(R.id.btnPlanFinalSchedule);
        btnHireEmployee = (Button) findViewById(R.id.btnHireEmployee);
        btnFireEmployee = (Button) findViewById(R.id.btnFireEmployee);
        btnViewFinalSchedule = (Button) findViewById(R.id.btnViewFinalSchedule);

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
                Intent intent = new Intent(ManagerLayout.this, PlanFinalSchedule.class);
                startActivity(intent);
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
                try {
                    JsonCheck obj = new JsonCheck();
                    boolean stime = obj.checkIfTimeIsCorrect();
                    boolean wcount = obj.checkWorkerCount();
                    boolean weekvalid = obj.checkIfWeekIsValid();
                    boolean shiftvalid = obj.checkIfShiftCountIsValid();
                    boolean weekhoursvalid = obj.checkIfWeeklyWorkHoursAreValid();
                    boolean dayscorrect = obj.checkIfDaysAreCorrectInWeek();
                    if(stime ==true && wcount == true && weekvalid == true && shiftvalid == true && weekhoursvalid==true)//&& dayscorrect ==true
                    {
                        Intent intent = new Intent(ManagerLayout.this, ViewFinalSchedule.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Context context = getApplicationContext();
                        CharSequence errortext = "";
                        if(stime == false)
                        {
                            errortext = "Λάθος τιμές JSON,οι ώρες εργασίας που έχουν δοθεί δεν είναι σωστές.";
                        }
                        else if(wcount == false)
                        {
                            errortext = "Λάθος τιμές JSON,το προσωπικό δεν είναι αρκετό.";
                        }
                        else if(weekvalid == false)
                        {
                            errortext = "Λάθος τιμές JSON,ο αριθμός των ημερών είναι λανθασμένος.";
                        }
                        else if(shiftvalid == false)
                        {
                            errortext = "Λάθος τιμές JSON,ο αριθμός των βαρδιών που έχει δοθεί δεν είναι σωστός.";
                        }
                        else if(weekhoursvalid == false)
                        {
                            errortext = "Λάθος τιμές JSON,ο μέγιστος αριθμός εβδομαδιαίων ωρών εργασίας που έχει δοθεί δεν είναι σωστός.";
                        }
                        /*else if(dayscorrect == false)
                        {
                            errortext = "Λάθος τιμές JSON,αντικρούονται τα δεδομένα αρχικής ημέρας.";
                        }*/

                        int duration = Toast.LENGTH_LONG;
                        Toast jsonerrortoast = Toast.makeText(context,errortext,duration);
                        jsonerrortoast.show();
                        Log.d("JSONCHECK","WRONG JSON VALUES");
                        Intent intent = new Intent(ManagerLayout.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}