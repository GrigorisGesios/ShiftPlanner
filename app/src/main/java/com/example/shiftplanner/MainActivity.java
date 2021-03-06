package com.example.shiftplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Manager.Login;
import com.example.shiftplanner.Manager.ManagerLayout;
import com.example.shiftplanner.Employee.EmployeeLogin;
import com.example.shiftplanner.Manager.ManagerLogin;

import org.json.JSONException;

import java.util.ArrayList;

import static com.example.shiftplanner.Employee.EmployeeLogin.loggedInEmployee;
import static com.example.shiftplanner.Manager.ManagerLogin.loggedInManager;

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
            parsT.parseWorkers2();
        } catch (JSONException e) {
            e.printStackTrace();
        }

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
                if(loggedInManager)
                {
                    Intent intent = new Intent(MainActivity.this, ManagerLayout.class);
                    startActivity(intent);
                }
                else if(!loggedInManager)
                {
                    Intent intent = new Intent(MainActivity.this, ManagerLogin.class);
                    startActivity(intent);
                }
            }
        });

        btnEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loggedInEmployee)
                {
                    Intent intent = new Intent(MainActivity.this, EmployeeLayout.class);
                    startActivity(intent);
                }
                else if(!loggedInEmployee)
                {
                    Intent intent = new Intent(MainActivity.this, EmployeeLogin.class);
                    startActivity(intent);
                }
            }
        });
    }
}
