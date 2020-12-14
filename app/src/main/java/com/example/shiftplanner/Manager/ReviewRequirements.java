package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.shiftplanner.R;
import com.example.shiftplanner.ToUI;

import org.json.JSONException;

public class ReviewRequirements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_requirements);
        ToUI obj = null;
        try {
            obj = new ToUI();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        TextView text1 = (TextView) findViewById(R.id.ViewReq_RevReq_TextView);

        obj.viewRequirements(text1);

    }
}

