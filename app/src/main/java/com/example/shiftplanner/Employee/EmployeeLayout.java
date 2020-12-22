package com.example.shiftplanner.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shiftplanner.JsonCheck;
import com.example.shiftplanner.MainActivity;
import com.example.shiftplanner.R;

import org.json.JSONException;

public class EmployeeLayout extends AppCompatActivity {

    Button btnGiveRequirements,btnViewFinalSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_layout);
        btnViewFinalSchedule = (Button) findViewById(R.id.btnViewFinalSchedule);
        btnGiveRequirements = (Button) findViewById(R.id.btnGiveRequirements);

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
                try {
                    JsonCheck obj = new JsonCheck();
                    boolean stime = obj.checkIfTimeIsCorrect();
                    boolean wcount = obj.checkWorkerCount();
                    if(stime ==true && wcount == true)
                    {
                        Intent intent = new Intent(EmployeeLayout.this, ViewFinalSchedule.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Context context = getApplicationContext();
                        CharSequence errortext = "";
                        if(stime == false && wcount == false)
                        {
                            errortext = "Λάθος τιμές JSON.";
                        }
                        else if(stime == false)
                        {
                            errortext = "Λάθος τιμές JSON,οι ώρες εργασίας υπερβαίνουν το 24ωρο.";
                        }
                        else if(wcount == false)
                        {
                            errortext = "Λάθος τιμές JSON,το προσωπικό δεν είναι αρκετό.";
                        }

                        int duration = Toast.LENGTH_LONG;
                        Toast jsonerrortoast = Toast.makeText(context,errortext,duration);
                        jsonerrortoast.show();
                        Log.d("JSONCHECK","WRONG JSON VALUES");
                        Intent intent = new Intent(EmployeeLayout.this, MainActivity.class);
                        startActivity(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}