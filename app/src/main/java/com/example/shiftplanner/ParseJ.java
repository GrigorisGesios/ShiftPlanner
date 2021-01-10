package com.example.shiftplanner;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.shiftplanner.Manager.Login;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.shiftplanner.Manager.ChooseData.dbchoice;

public class ParseJ
{
    private DatabaseReference database;
    public static Context parsecontext;

    ArrayList<Requirements> reqlist = new ArrayList<>();
    ArrayList<Employers> emplist = new ArrayList<>();
    public static ArrayList<Workers> workerslist = new ArrayList<>();
    public static ArrayList<Workers> workerslist2 = new ArrayList<>();
    ArrayList<Restrictions> restrlist = new ArrayList<>();
    ArrayList<Login> loginlist = new ArrayList<>();
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

    public ArrayList<Login> getlogin() {return loginlist;}



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
        if(dbchoice)
        {
            database = FirebaseDatabase.getInstance().getReference().child("employee");
            database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    int i=0;
                    for (DataSnapshot ds: snapshot.getChildren())
                    {
                        String fname = snapshot.child(String.valueOf(i)).child("firstName").getValue().toString();
                        String wprof = snapshot.child(String.valueOf(i)).child("workersProf").getValue().toString();
                        String lname = snapshot.child(String.valueOf(i)).child("lastName").getValue().toString();
                        String meraO = snapshot.child(String.valueOf(i)).child("meraO").getValue().toString();
                        String vardiaO = snapshot.child(String.valueOf(i)).child("vardiaO").getValue().toString();
                        String wID = snapshot.child(String.valueOf(i)).child("workersID").getValue().toString();
                        i++;
                        Workers work = new Workers(fname,lname,wID,wprof,meraO,vardiaO);

                        workerslist.add(work);
                    }

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }
        else if(!dbchoice)
        {
            JSONObject obj = new JSONObject(loadJSONFromAsset("Workers.json"));
            JSONArray jarr = (JSONArray) obj.get("employee");
            for(int i=0;i<jarr.length();i++)
            {
                JSONObject jin = jarr.getJSONObject(i);
                String fname = jin.getString("firstname");
                String wprof = jin.getString("idikotita");
                String wID = jin.getString("ID");
                String lname = jin.getString("lastname");
                String mO = jin.getString("oxi");
                String vO = jin.getString("vardiaO");
                Workers work = new Workers(fname,lname,wID,wprof,mO,vO);

                workerslist.add(work);
            }
        }

        return workerslist;
        //Log.d("Λίστα Employee",workerslist.toString());
    }

    public ArrayList<Workers> parseWorkers2() throws JSONException
    {
        database = FirebaseDatabase.getInstance().getReference().child("employee");
        database.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            int i=0;
        for (DataSnapshot ds: snapshot.getChildren())
        {
                String fname = snapshot.child(String.valueOf(i)).child("firstName").getValue().toString();
                String wprof = snapshot.child(String.valueOf(i)).child("workersProf").getValue().toString();
                String lname = snapshot.child(String.valueOf(i)).child("lastName").getValue().toString();
                String meraO = snapshot.child(String.valueOf(i)).child("meraO").getValue().toString();
                String vardiaO = snapshot.child(String.valueOf(i)).child("vardiaO").getValue().toString();
                String wID = snapshot.child(String.valueOf(i)).child("workersID").getValue().toString();
                i++;
            Workers work = new Workers(fname,lname,wID,wprof,meraO,vardiaO);

            workerslist2.add(work);
        }

    }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return  workerslist2;
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

    public int getMonth() throws JSONException {
        int x=0;
        JSONObject obj = new JSONObject(loadJSONFromAsset("Restrictions.json"));
        JSONArray jarr = (JSONArray) obj.get("restriction");
        JSONObject jin = jarr.getJSONObject(0);
        String monthstring = jin.getString("d_month");
        switch(monthstring)
        {
            case "January":
                x=0;
                break;
            case "February":
                x=1;
                break;
            case "March":
                x=2;
                break;
            case "April":
                x=3;
                break;
            case "May":
                x=4;
                break;
            case "June":
                x=5;
                break;
            case "July":
                x=6;
                break;
            case "August":
                x=7;
                break;
            case "September":
                x=8;
                break;
            case "October":
                x=9;
                break;
            case "November":
                x=10;
                break;
            case "December":
                x=11;
                break;
        }
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
    public ArrayList<Login> parselogin() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset("login.json"));
        JSONArray jarr = (JSONArray) obj.get("login");
        for(int i=0;i<jarr.length();i++)
        {
            JSONObject jin = jarr.getJSONObject(i);
            String loginID = jin.getString("ID");
            String loginidikotita = jin.getString("idikotita");
            String loginusername = jin.getString("username");
            String loginpassword = jin.getString("password");

            Login log = new Login (loginID,loginidikotita,loginusername,loginpassword);

            loginlist.add(log);
        }
        return loginlist;
        //Log.d("Λίστα Requirements",loginlist.toString());
    }
}

