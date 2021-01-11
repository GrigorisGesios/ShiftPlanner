package com.example.shiftplanner.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.example.shiftplanner.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileReader;
import java.util.Calendar;

import static com.example.shiftplanner.ParseJ.loadJSONFromAsset;

public class GiveRestrictions extends AppCompatActivity implements OnDateSetListener {

    private Spinner numweek, numshift, numday;
    Button Save;
    String mera, minas, xronos;

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
        numshift.setAdapter(adapterS);
        numday.setAdapter(adapterD);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                try {
                    String textW = numweek.getSelectedItem().toString();
                    String textS = numshift.getSelectedItem().toString();
                    String textD = numshift.getSelectedItem().toString();
                    JSONObject obj = new JSONObject(loadJSONFromAsset("Restrictions.json"));
                    JSONArray jarr = (JSONArray) obj.get("restriction");
                    String week = null;
                    String day = null;
                    String vard = null;
                    String b_day = null;
                    String b_month = null;
                    String b_year = null;

                    JSONObject jin = jarr.getJSONObject(0);
                    week = jin.getString("ar_week");
                    day = jin.getString("ar_days");
                    vard = jin.getString("ar_vard");
                    b_day = jin.getString("d_day");
                    b_month = jin.getString("d_month");
                    b_year = jin.getString("d_year");


                    if(!(textW.equals(week))){
                        JSONObject ar_week = jarr.getJSONObject(0);
                        ar_week.put("ar_week", textW);
                        obj.remove("restriction");
                        obj.put("restriction",ar_week);
                    }
                    if(!(textS.equals(vard))){
                        JSONObject ar_vard = jarr.getJSONObject(0);
                        ar_vard.put("ar_vard", textS);
                        obj.remove("restriction");
                        obj.put("restriction",ar_vard);
                    }
                    if( !(textD.equals(day))){
                        JSONObject ar_days = jarr.getJSONObject(0);
                        ar_days.put("ar_days", textD);
                        obj.remove("restriction");
                        obj.put("restriction",ar_days);
                    }
                    if( !(b_day.equals(mera))){
                        JSONObject d_day = jarr.getJSONObject(0);
                        d_day.put("d_day", mera);
                        obj.remove("restriction");
                        obj.put("restriction",d_day);
                    }
                    if( !(b_month.equals(minas))){
                        JSONObject d_month = jarr.getJSONObject(0);
                        d_month.put("d_month", minas);
                        obj.remove("restriction");
                        obj.put("restriction",d_month);
                    }
                    if( !(b_year.equals(xronos))){
                        JSONObject d_year = jarr.getJSONObject(0);
                        d_year.put("d_year", xronos);
                        obj.remove("restriction");
                        obj.put("restriction",d_year);
                    }
                    final String json = obj.toString();
                    Log.d("JSONCHECK5:",json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        });
    }


    private void showDatePicker(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mera = String.valueOf(dayOfMonth);
        minas = String.valueOf(month);
        xronos = String.valueOf(year);
    }
}