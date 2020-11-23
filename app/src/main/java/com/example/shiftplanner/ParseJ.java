package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ParseJ
{
    private Context context;
    ArrayList<HashMap<String,String>> workerslist = new ArrayList<>();



    public ParseJ(Context context)
    {
        this.context = context;
    }

        public void parseTest1() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Test.json"));
        JSONArray jarr = (JSONArray) obj.get("requirement");


        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String id = jin.getString("ID");
            String pref = jin.getString("protimisi");
            String shiftP = jin.getString("vardiaP");
            String denial = jin.getString("oxi");
            String shiftD = jin.getString("vardiaO");

            HashMap<String,String> worker = new HashMap<>();

            worker.put("ID",id);
            worker.put("Προτίμηση",pref);
            worker.put("Βάρδια Π",shiftP);
            worker.put("Όχι",denial);
            worker.put("Βάρδια Ο",shiftD);

            workerslist.add(worker);
        }

            Log.d("workerslist",workerslist.toString());

    }

    public String loadJSONFromAsset(String jsonname)
    {
        String json = null;
        try
        {
            InputStream is = context.getAssets().open(jsonname);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer,"UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
