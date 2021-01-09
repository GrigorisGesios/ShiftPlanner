package com.example.shiftplanner.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;

import org.json.JSONException;

import static com.example.shiftplanner.Algorithm.parseobj;
import static com.example.shiftplanner.Employee.EmployeeLayout.enteredid;
import static com.example.shiftplanner.Employee.EmployeeLayout.parseid;

public class DaysOffID extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_off_id);

        EditText idtext = findViewById(R.id.editTextID);
        Button idbtn = findViewById(R.id.btnID);
        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idtext.getText().toString();
                if (id.isEmpty()) {
                    Toast.makeText(DaysOffID.this, "Δεν έχετε δώσει ID εργαζομένου.", Toast.LENGTH_SHORT).show();
                } else {
                    ParseJ objj = new ParseJ();
                    try {
                        int numberofemployees = objj.getRestriction("sunol_pros");
                        parseid = Integer.parseInt(id);
                        if (parseid > 0 && parseid <= numberofemployees) {
                            enteredid = true;
                            Intent intent = new Intent(DaysOffID.this, DaysOff.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(DaysOffID.this, "Λάθος ID εργαζομένου.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }
}
