package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.shiftplanner.R;

public class GiveRestrictions extends AppCompatActivity {

    private Spinner numweek, numshift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_restrictions);

        Spinner numweek = (Spinner) findViewById(R.id.numweek);
        Spinner numshift = (Spinner) findViewById(R.id.numshifts);
        ArrayAdapter<String> adapterW = new ArrayAdapter<String>(GiveRestrictions.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.weeks));
        ArrayAdapter<String> adapterS = new ArrayAdapter<String>(GiveRestrictions.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.shifts));

        adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        numweek.setAdapter(adapterW);
        String textW = numweek.getSelectedItem().toString();
        numshift.setAdapter(adapterS);
        String textS = numshift.getSelectedItem().toString();
    }
}