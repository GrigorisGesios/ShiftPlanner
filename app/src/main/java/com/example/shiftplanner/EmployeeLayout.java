package com.example.shiftplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent intent = new Intent(EmployeeLayout.this, ViewFinalSchedule.class);
                startActivity(intent);
            }
        });
    }

}