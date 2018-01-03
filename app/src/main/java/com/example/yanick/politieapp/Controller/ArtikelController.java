package com.example.yanick.politieapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;
import com.example.yanick.politieapp.Model.Catagorie;

/**
 * Created by 0x000000 on 3-1-2018.
 */


public class ArtikelController {

    private Context context;
    private DatabaseHelper dbHelper;

    public ArtikelController(Context context)
    {
        this.context = context;
        this.dbHelper = DatabaseHelper.getHelper(this.context);
    }

    public void getItems()
    {
        Cursor rs = dbHelper.query(DatabaseInfo.ArtikelTables.ARTIKELEN, new
                String[]{"*"}, null, null, null, null, null);
        rs.moveToFirst();



        Log.d("Debuglog", "deze: "+rs.getCount());
    }

    public void setItems(){
        ContentValues value = new ContentValues();
        value.put(DatabaseInfo.ArtikelColom.TITEL, "Test_titel");
        value.put(DatabaseInfo.ArtikelColom.CATAGORIE, Catagorie.HERKKENING);
        value.put(DatabaseInfo.ArtikelColom.DATUM, 11111111);
        value.put(DatabaseInfo.ArtikelColom.TEKST, "Test_titel");

        Log.d("Debuglog", "Artikel geupload naar database!");
    }
}
