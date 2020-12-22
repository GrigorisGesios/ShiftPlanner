package com.example.shiftplanner.Manager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;
import com.example.shiftplanner.Workers;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HireEmployee extends AppCompatActivity {

    private DatabaseReference database;

    Button btnConfirmHireEmployee;
    TextView edTextGiveName, edTextGiveProf, edTextGiveId,edTextGiveLastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_employee);

        btnConfirmHireEmployee = (Button) findViewById(R.id.btnConfirmHireEmployee);
        edTextGiveName = (TextView) findViewById(R.id.edTextGiveName);
        edTextGiveProf = (TextView) findViewById(R.id.edTextGiveProf);
        edTextGiveId = (TextView) findViewById(R.id.edTextGiveId);
        edTextGiveLastName = (TextView) findViewById(R.id.edTextGiveLastName);

        database = FirebaseDatabase.getInstance().getReference().child("employee");

        btnConfirmHireEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = edTextGiveName.getText().toString();
                String lastname = edTextGiveLastName.getText().toString();
                String ID = edTextGiveId.getText().toString();
                String idikotita = edTextGiveProf.getText().toString();

                Workers worker = new Workers(firstname, lastname, ID, idikotita);

                database.child(ID).setValue(worker);
            }
        });
    }
}