package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.shiftplanner.R;

public class FireEmployee extends AppCompatActivity {

    Button btnConfirmFireEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_employee);

        btnConfirmFireEmployee = (Button) findViewById(R.id.btnFireEmployee);
    }
}