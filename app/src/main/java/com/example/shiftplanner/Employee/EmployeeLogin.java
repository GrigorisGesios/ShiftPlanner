package com.example.shiftplanner.Employee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;
import com.example.shiftplanner.ParseJ;
import org.json.JSONException;
import java.util.ArrayList;

import static com.example.shiftplanner.Manager.ManagerLogin.loggedInManager;

public class EmployeeLogin extends AppCompatActivity {

    Button Login;
    EditText name, password;
    ProgressBar loading;
    public static boolean loggedInEmployee = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);

        Login = (Button) findViewById(R.id.Login);
        name = (EditText) findViewById(R.id.Name);
        password = (EditText) findViewById(R.id.Password);
        loading = (ProgressBar) findViewById(R.id.loading);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usrname = name.getText().toString();
                String passwrd = password.getText().toString();

                if(usrname.isEmpty() || passwrd.isEmpty()){
                    if(usrname.isEmpty() && passwrd.isEmpty()){
                        Toast.makeText(EmployeeLogin.this, "Please fill Username and Password!", Toast.LENGTH_SHORT).show();
                    }else if (usrname.isEmpty()){
                        Toast.makeText(EmployeeLogin.this, "Please fill Username!", Toast.LENGTH_SHORT).show();
                        password.setText("");
                    }else{
                        Toast.makeText(EmployeeLogin.this, "Please fill Password!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    LoginManag(usrname,passwrd);
                }
            }
        });
    }

    private void LoginManag (final String usernm, final String psswrd){
        loading.setVisibility(View.VISIBLE);
        Login.setVisibility(View.GONE);

        ParseJ parseobj = new ParseJ();

        try {
            ArrayList<com.example.shiftplanner.Manager.Login> Checklist = parseobj.parselogin();
            ArrayList<String> userlist = new ArrayList<>();
            ArrayList<String> passlist = new ArrayList<>();
            ArrayList<Integer> positionlist = new ArrayList<>();
            for (int i=0; i<Checklist.size(); i++){
                if(Checklist.get(i).getidikotita().equals("ergatis")){
                    userlist.add(Checklist.get(i).getusername());
                    passlist.add(Checklist.get(i).getpassword());
                    positionlist.add(i);
                }
            }
            for (int k=0; k<positionlist.size(); k++){
                if (usernm.equals(userlist.get(k)) && psswrd.equals(passlist.get(k))){
                    loggedInEmployee = true;
                    loggedInManager = false;
                    Intent intent = new Intent(EmployeeLogin.this, EmployeeLayout.class);
                    startActivity(intent);
                    loading.setVisibility(View.GONE);
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
            loading.setVisibility(View.GONE);
            Login.setVisibility(View.VISIBLE);
            name.setText("");
            password.setText("");
            Toast.makeText(EmployeeLogin.this, "Please try again!", Toast.LENGTH_SHORT).show();
        }

    }
}