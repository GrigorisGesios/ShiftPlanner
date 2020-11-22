package com.example.shiftplanner;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ParseJ
{
    String JSONPATH = "src\\main\\assets\\Test.json";
    //String JSON = "{\"Person\":{\"Name\": \"Alex\",\"Lastname\": \"Koulelis\",\"Age\": 22 }}";
    private Context context;
    String name;


    public ParseJ(Context context)
    {
        this.context = context;
    }

    public String RetName() throws JSONException {
        JSONObject obj = new JSONObject(loadJSONFromAsset());
        JSONObject student = obj.getJSONObject("Person");
        name = student.getString("Name");
        return name;
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
