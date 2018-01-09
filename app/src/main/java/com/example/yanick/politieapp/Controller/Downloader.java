package com.example.yanick.politieapp.Controller;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 0x000000 on 9-1-2018.
 */

    //Wil graag een eigen class maken om de update-api te benaderen dmv een httpconnectie
    //Krijg geen log uit httprequest functie


class Downloader extends AsyncTask<String, String, String> {

    private static String updateUrl = "https://api.icndb.com";

    @Override
    protected String doInBackground(String... f_url) {
        int count;
        try {
            try {
                HttpURLConnection urlConnection = null;
                URL url = new URL(updateUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000);
                urlConnection.setConnectTimeout(10000);
                urlConnection.setDoOutput(true);
                urlConnection.connect();

                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuilder string = new StringBuilder();

                String line;
                while ((line = reader.readLine()) != null) {
                    string.append(line);
                }

                reader.close();

                Log.d("Debuglog", string.toString());

            } catch (Exception ex) {
                Log.d("Debuglog", ex.toString());
            }

        }catch (Exception exc) {
            Log.d("Debuglog", exc.toString());
        }

        return null;
    }

    @Override
    protected void onPreExecute() {

    }

}
