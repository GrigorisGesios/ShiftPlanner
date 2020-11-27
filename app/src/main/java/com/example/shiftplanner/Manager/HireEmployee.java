package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.shiftplanner.R;

public class HireEmployee extends AppCompatActivity {

    Button btnConfirmHireEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_employee);

        btnConfirmHireEmployee = (Button) findViewById(R.id.btnHireEmployee);
    }
}