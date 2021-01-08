package com.example.shiftplanner.Employee;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shiftplanner.R;
import com.example.shiftplanner.Schedule;
import com.example.shiftplanner.Week;
import com.example.shiftplanner.Workers;

import org.json.JSONException;

import java.util.ArrayList;

import static com.example.shiftplanner.Algorithm.masterworkerslist;
import static com.example.shiftplanner.Algorithm.parseobj;
import static com.example.shiftplanner.Employee.ViewFinalSchedule.weekslist;

public class DaysOff extends AppCompatActivity {
    public static int maximumdaysoff;

    static {
        try {
            maximumdaysoff = parseobj.getRestriction("max_adeia");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static int daysoff = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_off);

        CalendarView docv = (CalendarView) findViewById(R.id.daysoffcalendar);

        docv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                if(daysoff < maximumdaysoff)
                {
                    daysoff++;
                    String workerid = weekslist.get(0).getDaylist().get(0).getListofshifts().get(0).getShiftworkerslist().get(0).getWorkersID();
                    Log.d("WORKER:", String.valueOf(workerid));
                    ArrayList<Week> updatedweeklist = weekslist;
                    try {
                        showAlertDialog(view,updatedweeklist,workerid,year,month,dayOfMonth);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    weekslist = updatedweeklist;
                }
                else
                {
                    String message = "Έχετε φτάσει στον μέγιστο αριθμό αδειών(" + maximumdaysoff + ").";
                    Toast.makeText(DaysOff.this,message,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public ArrayList<Week> showAlertDialog(View v, ArrayList<Week> list, String workerid, int dyear, int dmonth, int dday) throws JSONException {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Επιβεβαίωση άδειας.");
        alert.setMessage("Θέλετε να ζητήσετε άδεια την ημέρα που επιλέξατε;");
        alert.setPositiveButton("Ναι", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String tmessage = null;
                Schedule obj = null;
                try {
                    obj = new Schedule();
                    tmessage = obj.returnWorkersforDaysOff(list,dday,dmonth,dyear,workerid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(DaysOff.this,tmessage,Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("Όχι", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DaysOff.this,"Ακύρωση επιβεβαίωσης.",Toast.LENGTH_LONG).show();
            }
        });
        alert.create().show();
        return list;
    }
}
