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

    ArrayList<HashMap<String,String>> reqlist = new ArrayList<>();
    ArrayList<HashMap<String,String>> emplist = new ArrayList<>();
    ArrayList<HashMap<String,String>> workerslist = new ArrayList<>();


    public ParseJ(Context context)
    {
        this.context = context;
    }

        public void parseReq() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Requirements.json"));
        JSONArray jarr = (JSONArray) obj.get("requirement");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String id = jin.getString("ID");
            String pref = jin.getString("protimisi");
            String shiftP = jin.getString("vardiaP");
            String denial = jin.getString("oxi");
            String shiftD = jin.getString("vardiaO");

            HashMap<String,String> workerreq = new HashMap<>();

            workerreq.put("ID",id);
            workerreq.put("Προτίμηση",pref);
            workerreq.put("Βάρδια Π",shiftP);
            workerreq.put("Όχι",denial);
            workerreq.put("Βάρδια Ο",shiftD);

            reqlist.add(workerreq);
        }
            Log.d("Λίστα Requirements",reqlist.toString());
    }

    public void parseWorkers() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Workers.json"));
        JSONArray jarr = (JSONArray) obj.get("employee");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String fname = jin.getString("firstname");
            String proff = jin.getString("idikotita");
            String empID = jin.getString("ID");
            String lname = jin.getString("lastname");

            HashMap<String,String> employee = new HashMap<>();

            employee.put("Όνομα",fname);
            employee.put("Επίθετο",lname);
            employee.put("Ειδικότητα",proff);
            employee.put("ID",empID);

            workerslist.add(employee);
        }
        Log.d("Λίστα Employee",workerslist.toString());
    }

    public void parseEmp() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Employers.json"));
        JSONArray jarr = (JSONArray) obj.get("employer");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String fname = jin.getString("firstname");
            String proff = jin.getString("idikotita");
            String empID = jin.getString("ID");
            String lname = jin.getString("lastname");

            HashMap<String,String> employer = new HashMap<>();

            employer.put("Όνομα",fname);
            employer.put("Επίθετο",lname);
            employer.put("Ειδικότητα",proff);
            employer.put("ID",empID);

            emplist.add(employer);
        }
        Log.d("Λίστα Employer",emplist.toString());
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
