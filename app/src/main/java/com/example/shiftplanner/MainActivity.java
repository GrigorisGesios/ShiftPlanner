package com.example.shiftplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Manager.ManagerLayout;

import org.json.JSONException;

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
            JsonCheck joT = new JsonCheck();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //ΚΩΔΙΚΑΣ ΓΙΑ ΕΚΤΕΛΕΣΗ ΤΩΝ ΜΕΘΟΔΩΝ ΑΠΟ PARSEJ

        /*TestClass t = null;
        try {
            t = new TestClass();
            t.testMethod();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/


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
