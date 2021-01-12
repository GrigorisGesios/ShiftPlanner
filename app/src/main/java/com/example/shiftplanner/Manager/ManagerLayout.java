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
    public static ArrayList<Week> weekslist = new ArrayList<Week>();

    public ManagerLayout() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_layout);

        btnGiveRestrictions = (Button) findViewById(R.id.btnGiveRestrictions);
        //btnReviewRequirements = (Button) findViewById(R.id.btnReviewRequirements);
        btnPlanFinalSchedule = (Button) findViewById(R.id.btnPlanFinalSchedule);
        btnHireEmployee = (Button) findViewById(R.id.btnHireEmployee);
        btnFireEmployee = (Button) findViewById(R.id.btnFireEmployee);
        btnViewFinalSchedule = (Button) findViewById(R.id.btnViewFinalSchedule);

        btnGiveRestrictions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!schedulecreated)
                {
                    Intent intent = new Intent(ManagerLayout.this, GiveRestrictions.class);
                    startActivity(intent);
                }
                else if(schedulecreated)
                {
                    Toast.makeText(ManagerLayout.this,"Έχει ήδη δημιουργηθεί πρόγραμμα!",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ManagerLayout.this, ManagerLayout.class);
                    startActivity(intent);
                }

            }
        });

        /*btnReviewRequirements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagerLayout.this, ReviewRequirements.class);
                startActivity(intent);
            }
        });*/

        /*btnPlanFinalSchedule.setOnClickListener(new View.OnClickListener() {
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
        });*/

        btnPlanFinalSchedule.setOnClickListener(new View.OnClickListener() {
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
                        String message = null;
                        if(!schedulecreated)
                        {
                            //dbchoice = true;
                            message = "Επιλέχθηκαν τα δεδομένα απο την βάση δεδομένων και δημιουργήθηκε πρόγραμμα εργασιών.";
                            Toast.makeText(ManagerLayout.this,message,Toast.LENGTH_LONG).show();
                            try {
                                weekslist = algobj.createSchedule();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            schedulecreated = true;
                            Intent intent = new Intent(ManagerLayout.this, ManagerLayout.class);
                            startActivity(intent);
                        }
                        else if(schedulecreated)
                        {
                            message = "Υπάρχει ήδη πρόγραμμα εργασιών. Πατήστε το κουμπί \"View Final Schedule\" για να το δείτε.";
                            Toast.makeText(ManagerLayout.this,message,Toast.LENGTH_SHORT).show();
                        }
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