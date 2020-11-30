package com.example.shiftplanner;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ParseRes extends AppCompatActivity {

        ArrayList<String> restrictionlist = new ArrayList<>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            get_json();
        }

        public void get_json()
        {
            String restrictions = null;
            int i=1;
            try
            {
                InputStream is = getAssets().open("Restrictions.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                restrictions = new String(buffer,"UTF-8");

                JSONArray jsonArray = new JSONArray(restrictions);

                JSONObject obj = jsonArray.getJSONObject(i);
                {
                    restrictionlist.add(obj.getString("ar_vard"));
                    restrictionlist.add(obj.getString("prwi_pros"));
                    restrictionlist.add(obj.getString("apogeuma_pros"));
                    restrictionlist.add(obj.getString("vradu_pros"));
                    restrictionlist.add(obj.getString("sun_wres"));
                    restrictionlist.add(obj.getString("wres_evd"));
                    restrictionlist.add(obj.getString("max_adeia"));
                }
                Toast.makeText(getApplicationContext(),restrictionlist.toString(),Toast.LENGTH_LONG).show();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
        }
    }