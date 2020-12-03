package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import static com.example.shiftplanner.ParseJ.loadJSONFromAsset;
import static java.lang.Integer.parseInt;

public class Day {

    private Context context;

    private Shift shiftobj = new Shift();
    private ParseJ parseobj = new ParseJ();

    private int totalworkers = 0;



    ArrayList<String> shiftRestrictions = new ArrayList<String>();

    ArrayList<String> dailyshiftlist = new ArrayList<String>();

    public Day() throws JSONException {
    }


    public ArrayList<String> DailyShifts() throws JSONException {
        totalworkers = parseobj.getRestriction("sunol_pros");
        for(int i =0;i<totalworkers-1;i++)
        {
            dailyshiftlist=shiftobj.changeToString();
        }

        Log.d("DAILYSHIFTS:", String.valueOf(dailyshiftlist)) ;
        return dailyshiftlist;
    }

}






