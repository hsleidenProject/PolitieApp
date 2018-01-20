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
import com.android.volley.toolbox.Volley;
import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;
import com.example.yanick.politieapp.Model.Artikel;

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
    private static final String DOMAIN = "http://173.212.242.179";
    private static final String PATH = "/android/artikel.php?timestamp=";

    public static void setUpdateOnce(Context context) {

        dbHelper = DatabaseHelper.getHelper(context);
        ContentValues value = new ContentValues();
        value.put(DatabaseInfo.VersionColom.VERSION, 1.0);
        dbHelper.insert(DatabaseInfo.VersionTable.VERSION, null, value);
    }

    public static void UpdateDatabase(final Context context, long lastTimestamp) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        String getUrl = DOMAIN + PATH + String.valueOf(lastTimestamp);
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.GET, getUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray artikelArray = response.getJSONArray("artikelen");
                    ArtikelController artikelController = new ArtikelController(context);
                    for (int a = 0; a < artikelArray.length(); a++) {
                        JSONObject art = artikelArray.getJSONObject(a);

                        String titel = art.getString("titel");
                        String tekst = art.getString("tekst");
                        Long datum = art.getLong("datum");
                        int catagorie = art.getInt("catagorie");

                        Artikel artikel = new Artikel(titel, tekst, datum, catagorie);
                        Log.d("Debuglog", "Nieuw artikel toegevoegd in lokale database: " + titel + " " + String.valueOf(datum));

                        artikelController.addArtikel(artikel);
                    }
                } catch (org.json.JSONException ex) {
                    Log.d("Debuglog", ex.toString());
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Debuglog", error.toString());
            }
        });
        requestQueue.add(obreq);
    }
}