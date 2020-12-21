package com.example.shiftplanner.Manager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FireEmployee extends AppCompatActivity {

    private DatabaseReference database;

    Button btnShowEmployee;
    Button btnConfirmFireEmployee;
    TextView edTextGiveName, edTextGiveProf, edTextGiveId,edTextGiveLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_employee);

        btnConfirmFireEmployee = (Button) findViewById(R.id.btnConfirmFireEmployee);
        edTextGiveName = (TextView) findViewById(R.id.edTextGiveName);
        edTextGiveProf = (TextView) findViewById(R.id.edTextGiveProf);
        edTextGiveId = (TextView) findViewById(R.id.edTextGiveId);
        edTextGiveLastName = (TextView) findViewById(R.id.edTextGiveLastName);
        btnShowEmployee = (Button) findViewById(R.id.btnShowEmployee);

        database = FirebaseDatabase.getInstance().getReference().child("employee");

        btnConfirmFireEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String childNum = edTextGiveId.getText().toString();
                database = FirebaseDatabase.getInstance().getReference().child("employee").child(childNum);
                database.removeValue();
            }
        });

        btnShowEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String childNum = edTextGiveId.getText().toString();
                database = FirebaseDatabase.getInstance().getReference().child("employee").child(childNum);
                database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String firstname = snapshot.child("firstname").getValue().toString();
                        String idikotita = snapshot.child("idikotita").getValue().toString();
                        String lastname = snapshot.child("lastname").getValue().toString();
                        String ID = snapshot.child("ID").getValue().toString();
                        edTextGiveName.setText(firstname);
                        edTextGiveProf.setText(idikotita);
                        edTextGiveLastName.setText(lastname);
                        edTextGiveId.setText(ID);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}