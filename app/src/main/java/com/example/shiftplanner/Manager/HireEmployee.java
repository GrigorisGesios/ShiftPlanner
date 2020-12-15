package com.example.shiftplanner.Manager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;
import com.example.shiftplanner.Workers;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HireEmployee extends AppCompatActivity {

    private DatabaseReference database;

    Button btnConfirmHireEmployee;
    TextView edTextGiveName, edTextGiveProf, edTextGiveId,edTextGiveLastName;
    Workers worker;
    long counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_employee);

        btnConfirmHireEmployee = (Button) findViewById(R.id.btnConfirmHireEmployee);
        edTextGiveName = (TextView) findViewById(R.id.edTextGiveName);
        edTextGiveProf = (TextView) findViewById(R.id.edTextGiveProf);
        edTextGiveId = (TextView) findViewById(R.id.edTextGiveId);
        edTextGiveLastName = (TextView) findViewById(R.id.edTextGiveLastName);
        worker = new Workers();

        database = FirebaseDatabase.getInstance().getReference().child("employee");

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    counter=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnConfirmHireEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                worker.setFirstName(edTextGiveName.getText().toString().trim());
                worker.setWorkersID(edTextGiveId.getText().toString().trim());
                worker.setWorkersProf(edTextGiveProf.getText().toString().trim());
                worker.setLastName(edTextGiveLastName.getText().toString().trim());
                database.child(String.valueOf(counter)).setValue(worker);
            }
        });
    }
}