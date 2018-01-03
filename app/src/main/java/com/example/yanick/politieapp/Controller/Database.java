package com.example.yanick.politieapp.Controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;


/**
 * Created by 0x000000 on 3-1-2018.
 */

public class Database {

    DatabaseHelper dbHelper;

    public Database(Context context)
    {
        this.dbHelper = DatabaseHelper.getHelper(context);
    }

    public void test()
    {
        Cursor rs = dbHelper.query(DatabaseInfo.ArtikelTables.ARTIKELEN, new String[]{"*"}, null, null, null, null, null);

        rs.moveToFirst();
        // Skip : de lege elementen vooraan de rij.
        // Maar : de rij kan nog steeds leeg zijn
        // Hoe : lossen we dit op ??

        // Haalt de name uit de resultset
        String name = (String) rs.getString(rs.getColumnIndex("name"));

        // Even checken of dit goed binnen komt
        Log.d("Michiel deze gevonden=", "deze :"+name);
    }


}
