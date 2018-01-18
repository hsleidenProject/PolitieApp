package com.example.yanick.politieapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 0x000000 on 9-1-2018.
 */

public class UpdateController {

    private static DatabaseHelper dbHelper;
    public static void setUpdateOnce(Context context) {

        dbHelper = DatabaseHelper.getHelper(context);
        ContentValues value = new ContentValues();
        value.put(DatabaseInfo.VersionColom.VERSION, 1.0);
        dbHelper.insert(DatabaseInfo.VersionTable.VERSION, null, value);
    }

    public static void UpdateDatabase(long lastTimestamp) {
        //Andere methode gebruiken om te controleren of db up-todate is.
        //API returns een lijst (JSON) met nieuwe artikelen gepost na invoer timestamp

        String getUrl = "https://randomuser.me/api/";
        Log.d("Debuglog", "Requesting json");
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET,  getUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("Debuglog", response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Debuglog", error.toString());
            }
        });
    }
}