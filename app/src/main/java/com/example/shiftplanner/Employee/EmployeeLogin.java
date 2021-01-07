package com.example.shiftplanner.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;

public class EmployeeLogin extends AppCompatActivity {

    Button Login;
    EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Login = (Button) findViewById(R.id.Login);
        name = (EditText) findViewById(R.id.Name);
        password = (EditText) findViewById(R.id.Password);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name.getText().toString();
                password.getText().toString();

                Intent intent = new Intent(EmployeeLogin.this, EmployeeLayout.class);
                startActivity(intent);
            }
        });
    }
}
