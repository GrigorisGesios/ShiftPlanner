package com.example.shiftplanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String firstname = new String();
        TextView onomaTView;
        ParseJ parsetest = new ParseJ(this);

        try {
            firstname = parsetest.RetName();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        onomaTView = (TextView) findViewById(R.id.onomatest);
        onomaTView.setText("ONOMA:" + firstname);
    }
}