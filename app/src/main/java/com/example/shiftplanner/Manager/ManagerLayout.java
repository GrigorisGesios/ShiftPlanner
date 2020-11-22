package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shiftplanner.R;

public class ManagerLayout extends AppCompatActivity {

    Button btnGiveRestrictions,btnReviewRequirements,btnPlanFinalSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_layout);

        btnGiveRestrictions = (Button) findViewById(R.id.btnGiveRestrictions);
        btnReviewRequirements = (Button) findViewById(R.id.btnReviewRequirements);
        btnPlanFinalSchedule = (Button) findViewById(R.id.btnPlanFinalSchedule);

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


    }
}