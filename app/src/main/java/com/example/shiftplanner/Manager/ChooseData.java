package com.example.shiftplanner.Manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.Algorithm;
import com.example.shiftplanner.JsonCheck;
import com.example.shiftplanner.MainActivity;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.util.ArrayList;

import static com.example.shiftplanner.Manager.ManagerLayout.schedulecreated;

public class ChooseData extends AppCompatActivity {

    //private Algorithm algobj = new Algorithm();
    //public static ArrayList<Week> weekslist = new ArrayList<Week>();
    public static boolean dbchoice = false;

    public ChooseData() throws JSONException {
    }

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_or_db);


        Button btndb = findViewById(R.id.btn_choose_db);
        Button btnlocal = findViewById(R.id.btn_choose_json);

        btndb.setOnClickListener(new View.OnClickListener() {
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
                            dbchoice = true;
                            message = "Επιλέχθηκαν τα δεδομένα απο την βάση δεδομένων και δημιουργήθηκε πρόγραμμα εργασιών.";
                            Toast.makeText(ChooseData.this,message,Toast.LENGTH_LONG).show();
                            /*try {
                                weekslist = algobj.createSchedule();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }*/
                            schedulecreated = true;
                            Intent intent = new Intent(ChooseData.this, ManagerLayout.class);
                            startActivity(intent);
                        }
                        else if(schedulecreated)
                        {
                            message = "Υπάρχει ήδη πρόγραμμα εργασιών. Πατήστε το κουμπί \"View Final Schedule\" για να το δείτε.";
                            Toast.makeText(ChooseData.this,message,Toast.LENGTH_SHORT).show();
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
                        Intent intent = new Intent(ChooseData.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        btnlocal.setOnClickListener(new View.OnClickListener() {
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
                            dbchoice = false;
                            message = "Επιλέχθηκαν τα δεδομένα απο το τοπικό αρχείο JSON και δημιουργήθηκε πρόγραμμα εργασιών.";
                            Toast.makeText(ChooseData.this,message,Toast.LENGTH_LONG).show();
                            /*try {
                                weekslist = algobj.createSchedule();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }*/
                            schedulecreated = true;
                            Intent intent = new Intent(ChooseData.this, ManagerLayout.class);
                            startActivity(intent);
                        }
                        else if(schedulecreated)
                        {
                            message = "Υπάρχει ήδη πρόγραμμα εργασιών. Πατήστε το κουμπί \"View Final Schedule\" για να το δείτε.";
                            Toast.makeText(ChooseData.this,message,Toast.LENGTH_LONG).show();
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
                        Intent intent = new Intent(ChooseData.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
