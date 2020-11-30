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

    String numberOfShifts;

    /*String morningstaff = null;
    String afternoonstaff = null;
    String nightstaff = null;
    String dailyhours = null;*/
    int totalworkers = 0;

    ArrayList<String> shiftRestrictions = new ArrayList<String>();

    ArrayList<String> dailyshiftlist = new ArrayList<String>();

    public Day() throws JSONException {
    }


    public Integer parseTotalWorkers() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("restrictions.json"));
        JSONArray jarr = (JSONArray) obj.get("restriction");
        int tw=0;
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String jsontotalworkers = jin.getString("sunol_pros");
            tw = parseInt(jsontotalworkers);
        }
        return tw;
    }

    public ArrayList<String> DailyShifts() throws JSONException {
        totalworkers = parseTotalWorkers();
        for(int i =0;i<totalworkers-1;i++)
        {
            dailyshiftlist=shiftobj.changeToString();
        }

        Log.d("DAILYSHIFTS:", String.valueOf(dailyshiftlist)) ;
        return dailyshiftlist;
    }

}






