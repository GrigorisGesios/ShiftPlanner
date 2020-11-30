package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatRadioButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

            Workers work = new Workers(fname,lname,wID,wprof);

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
        JSONObject obj = new JSONObject(loadJSONFromAsset("restrictions.json"));
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


    public void ShowRestrictions(TextView tView) throws JSONException {
        ArrayList<Restrictions> list = parseRes();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getNumvard());
            sb.append(" ");
            sb.append(list.get(i).getMornvard());
            sb.append(" ");
            sb.append(list.get(i).getNoonvard());
            sb.append(" ");
            sb.append(list.get(i).getNightvard());
            sb.append(" ");
            sb.append(list.get(i).getHoursvard());
            sb.append(" ");
            sb.append(list.get(i).getHoursweek());
            sb.append(" ");
            sb.append(list.get(i).getAdeiamax());
            sb.append("\n");
        }
        //Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }

    public void ShowEmployers(TextView tView) throws JSONException {
        ArrayList<Employers> list = parseEmp();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getFirstName());
            sb.append(" ");
            sb.append(list.get(i).getEmployerProff());
            sb.append(" ");
            sb.append(list.get(i).getEmployerID());
            sb.append(" ");
            sb.append(list.get(i).getLastName());
            sb.append("\n");
        }
        //Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }

    public void ShowWorkers(TextView tView) throws JSONException {
        ArrayList<Workers> list =  parseWorkers();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getFirstName());
            sb.append(" ");
            sb.append(list.get(i).getWorkersProf());
            sb.append(" ");
            sb.append(list.get(i).getWorkersID());
            sb.append(" ");
            sb.append(list.get(i).getLastName());
            sb.append("\n");
        }
        //Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }

    public void ShowRequirements(TextView tView) throws JSONException {
        ArrayList<Requirements> list =  parseReq();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++)
        {
            sb.append(list.get(i).getRequirementsID());
            sb.append(" ");
            sb.append(list.get(i).getPreference());
            sb.append(" ");
            sb.append(list.get(i).getVardiaP());
            sb.append(" ");
            sb.append(list.get(i).getVardiaO());
            sb.append("\n");
        }
        //Log.d("Λίστα Employer",sb.toString());
        tView.setText(sb.toString());
    }
}
