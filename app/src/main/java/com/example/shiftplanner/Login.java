package com.example.shiftplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shiftplanner.Employee.EmployeeLayout;
import com.example.shiftplanner.Manager.ManagerLayout;

public class Login extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private  int counter=5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name=(EditText)findViewById(R.id.etName);
        password=(EditText)findViewById(R.id.etPassword);
        info=(TextView)findViewById(R.id.etName);
        login=(Button) findViewById(R.id.btnlogin);
        info.setText("Number of attempts"+String.valueOf(counter));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });
    }
    private void validate (String userName,String userPassword){
        if ((userName=="admin") && (userPassword=="1234")) {
            Intent intent = new Intent(Login.this, ManagerLayout.class);
            startActivity(intent);
        }
        else if ((userName=="Employee")&&(userPassword=="4321")){
            Intent intent = new Intent(Login.this, EmployeeLayout.class);
            startActivity(intent);
        }
        else
        {
            counter--;
            info.setText("Number Of Attempts"+ String.valueOf(counter));
            if(counter==0){
                login.setEnabled(false);
            }
        }

    }
}