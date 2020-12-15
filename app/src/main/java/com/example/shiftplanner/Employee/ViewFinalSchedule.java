package com.example.shiftplanner.Employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.shiftplanner.ParseJ;
import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Shift;
import com.example.shiftplanner.ToUI;
import com.example.shiftplanner.Week;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ViewFinalSchedule extends AppCompatActivity {
    private static final String FILE_NAME = "Schedule.txt";
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_final_schedule);

        textView1 = (TextView) findViewById(R.id.EmployerView);


        try {
            Schedule scheduleobj = new Schedule();
            scheduleobj.printSchedule(textView1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void load(View v) {
        FileInputStream fis =null;
        try {
            fis =openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br= new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String textSchedule;

            while ((textSchedule = br.readLine() != null)) {
                sb.append(textSchedule).append("\n");
            }
            textView1.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}