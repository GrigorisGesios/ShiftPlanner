package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.example.shiftplanner.R;

import java.util.Calendar;

public class GiveRestrictions extends AppCompatActivity implements OnDateSetListener {

    private Spinner numweek, numshift, numday;
    Button Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_restrictions);

        Spinner numweek = (Spinner) findViewById(R.id.numweek);
        Spinner numshift = (Spinner) findViewById(R.id.numshifts);
        Spinner numday = (Spinner) findViewById(R.id.numdays);
        Save = (Button) findViewById(R.id.save);

        findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        ArrayAdapter<String> adapterW = new ArrayAdapter<String>(GiveRestrictions.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.weeks));
        ArrayAdapter<String> adapterS = new ArrayAdapter<String>(GiveRestrictions.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.shifts));
        ArrayAdapter<String> adapterD = new ArrayAdapter<String>(GiveRestrictions.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.days));

        adapterW.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        numweek.setAdapter(adapterW);
        String textW = numweek.getSelectedItem().toString();
        numshift.setAdapter(adapterS);
        String textS = numshift.getSelectedItem().toString();
        numday.setAdapter(adapterS);
        String textD = numshift.getSelectedItem().toString();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
    }
}