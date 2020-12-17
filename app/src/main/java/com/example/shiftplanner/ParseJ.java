package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseJ
{
    public static Context parsecontext;

    ArrayList<Requirements> reqlist = new ArrayList<>();
    ArrayList<Employers> emplist = new ArrayList<>();
    public static ArrayList<Workers> workerslist = new ArrayList<>();
    ArrayList<Restrictions> restrlist = new ArrayList<>();

    public ParseJ() {

    }

    public ArrayList<Requirements> getReqlist() {
        return reqlist;
    }

    public ArrayList<Employers> getEmplist() {
        return emplist;
    }

    public ArrayList<Workers> getWorkerslist() {
        return workerslist;
    }

    public ParseJ(Context context)
    {
        this.parsecontext = context;
    }

    public static Context getParsecontext() {
        return parsecontext;
    }



    public ArrayList<Requirements> parseReq() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Requirements.json"));
        JSONArray jarr = (JSONArray) obj.get("requirement");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String requirementsID = jin.getString("ID");
            String requirementsPref = jin.getString("protimisi");
            String shiftP = jin.getString("vardiaP");
            String denial = jin.getString("oxi");
            String shiftD = jin.getString("vardiaO");

            Requirements req = new Requirements(requirementsID,requirementsPref,shiftP,denial,shiftD);

            reqlist.add(req);
        }
        return reqlist;
        //Log.d("Λίστα Requirements",reqlist.toString());
    }

    public ArrayList<Workers> parseWorkers() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Workers.json"));
        JSONArray jarr = (JSONArray) obj.get("employee");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String fname = jin.getString("firstname");
            String wprof = jin.getString("idikotita");
            String wID = jin.getString("ID");
            String lname = jin.getString("lastname");
            String vP = jin.getString("vardiaP");
            String mO = jin.getString("oxi");
            String vO = jin.getString("vardiaO");

            Workers work = new Workers(fname,lname,wID,wprof,vP,mO,vO);

            workerslist.add(work);
        }
        return workerslist;
        //Log.d("Λίστα Employee",workerslist.toString());
    }

    public ArrayList<Employers> parseEmp() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Employers.json"));
        JSONArray jarr = (JSONArray) obj.get("employer");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String fname = jin.getString("firstname");
            String prof = jin.getString("idikotita");
            String empID = jin.getString("ID");
            String lname = jin.getString("lastname");

            Employers emp = new Employers(fname,lname,empID,prof);

            emplist.add(emp);
        }
        //Log.d("Λίστα Employer",emplist.toString());

        return emplist;
    }

    public ArrayList<Restrictions> parseRes() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("Restrictions.json"));
        JSONArray jarr = (JSONArray) obj.get("restriction");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String vardnum = jin.getString("ar_vard");
            String mornwork = jin.getString("prwi_pros");
            String noonwork = jin.getString("apogeuma_pros");
            String nightwork = jin.getString("vradu_pros");
            String dailyhours = jin.getString("sun_wres");
            String weeklyhours = jin.getString("wres_evd");
            String maxadeia = jin.getString("max_adeia");

            Restrictions restr = new Restrictions(vardnum, mornwork, noonwork, nightwork, dailyhours, weeklyhours, maxadeia);

            restrlist.add(restr);
        }
           Log.d("Λίστα Restrictions",restrlist.toString());

        return restrlist;
    }

    public int getRestriction(String restriction) throws JSONException {
        int x=0;
        JSONObject obj = new JSONObject(loadJSONFromAsset("Restrictions.json"));
        JSONArray jarr = (JSONArray) obj.get("restriction");
            JSONObject jin = jarr.getJSONObject(0);
            String vardnum = jin.getString(restriction);
            x = Integer.parseInt(vardnum);
        return x;
    }

    public static String loadJSONFromAsset(String jsonname)
    {
        String json = null;
        try
        {
            InputStream is = parsecontext.getAssets().open(jsonname);
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
