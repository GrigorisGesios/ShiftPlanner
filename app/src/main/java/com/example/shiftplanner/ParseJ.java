package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ParseJ
{
    private Context context;
    HashMap<String,String> workers = new HashMap<String, String>();
    ArrayList<HashMap<String,String>> workerslist = new ArrayList<>();
    String value,name,id;

    public ParseJ(Context context)
    {
        this.context = context;
    }

        public void RetName() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
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
            worker.put("protimisi",pref);
            worker.put("vardiaP",shiftP);
            worker.put("oxi",denial);
            worker.put("vardiaD",shiftD);

            workerslist.add(worker);
        }
            Log.d("workerslist",workerslist.toString());
    }

    public String loadJSONFromAsset()
    {
        String json = null;
        try
        {
            InputStream is = context.getAssets().open("Test.json");
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
