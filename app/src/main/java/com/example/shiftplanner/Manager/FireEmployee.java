package com.example.shiftplanner.Manager;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;

public class FireEmployee extends AppCompatActivity {

    Button btnConfirmFireEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_employee);

        btnConfirmFireEmployee = (Button) findViewById(R.id.btnConfirmFireEmployee);
    }
}