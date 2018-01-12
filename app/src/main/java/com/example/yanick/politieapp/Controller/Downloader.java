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
    //Vage out of bounds error met het downloaden van een stukje tekst..
    
public class Downloader extends AsyncTask<String, Void, String> {

    private Exception exception;

    protected String doInBackground(String... urls) {
        try
        {


            HttpURLConnection urlConnection = null;
            URL url = new URL(urls[0]);
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

            Log.d("Debuglog", urls[0]);

            reader.close();

            Log.d("Debuglog", string.toString());

            return string.toString();


        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(String feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}