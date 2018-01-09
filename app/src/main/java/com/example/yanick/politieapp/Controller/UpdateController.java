package com.example.yanick.politieapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;

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

    public static int getVersion(Context context) {

        //Error omdat 'Database niet bestaat' terwijl er wel een query kan draaien die db vult met info...
        dbHelper = DatabaseHelper.getHelper(context);
        Cursor cursor = dbHelper.query(DatabaseInfo.VersionTable.VERSION, new String[]{"*"}, null, null, null, null, null);
        cursor.moveToFirst();
        String version = cursor.getString(cursor.getColumnIndex(DatabaseInfo.VersionColom.VERSION));
        return Integer.parseInt(version);
    }

    public static void UpdateDatabase(long lastTimestamp) {
        //Andere methode gebruiken om te controleren of db up-todate is.
        //API returns een lijst (JSON) met nieuwe artikelen gepost na invoer timestamp


        new Downloader().execute();



    }
}