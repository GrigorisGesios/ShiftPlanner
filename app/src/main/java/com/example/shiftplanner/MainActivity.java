package com.example.shiftplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import android.view.View;
import android.widget.Button;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Manager.ManagerLayout;

public class MainActivity extends AppCompatActivity {

    Button btnManager, btnEmployee;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΚΤΕΛΕΣΗ ΤΩΝ ΜΕΘΟΔΩΝ ΑΠΟ PARSEJ
        ParseJ parsT = new ParseJ(this);

        try {
            parsT.parseEmp();
            parsT.parseWorkers();
            parsT.parseReq();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΚΤΕΛΕΣΗ ΤΩΝ ΜΕΘΟΔΩΝ ΑΠΟ PARSEJ


        btnManager = (Button) findViewById(R.id.btnManager);
        btnEmployee = (Button) findViewById(R.id.btnEmployee);

        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
}