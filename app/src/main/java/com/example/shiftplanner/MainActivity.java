package com.example.shiftplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Manager.ManagerLayout;

public class MainActivity extends AppCompatActivity {

    Button btnManager, btnEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnManager = (Button) findViewById(R.id.btnManager);
        btnEmployee = (Button) findViewById(R.id.btnEmployee);

        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManagerLayout.class);
                startActivity(intent);
            }
        });

        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmployeeLayout.class);
                startActivity(intent);
            }
        });

    }
}