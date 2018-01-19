package com.example.yanick.politieapp.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.yanick.politieapp.Database.DatabaseHelper;
import com.example.yanick.politieapp.Database.DatabaseInfo;
import com.example.yanick.politieapp.Model.Artikel;
import com.example.yanick.politieapp.Model.Catagorie;

import java.util.ArrayList;

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

    public ArrayList<Artikel> getArtikelen(int catagorie)
    {
        String selection = DatabaseInfo.ArtikelColom.CATAGORIE + " = ?";
        String[] selectionArgs = {String.valueOf(catagorie)};
        Cursor cursor = this.dbHelper.query(DatabaseInfo.ArtikelTables.ARTIKELEN, new String[]{"*"}, selection , selectionArgs, null, null, null);

        cursor.moveToFirst();
        Log.d("Debuglog", "Gezocht naar catagorie [" + catagorie + "] aantal gevonden resultaten: " + String.valueOf(cursor.getCount()));

        ArrayList<Artikel> artikelen = new ArrayList<Artikel>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            String titel =cursor.getString(cursor.getColumnIndex(DatabaseInfo.ArtikelColom.TITEL));
            String tekst =cursor.getString(cursor.getColumnIndex(DatabaseInfo.ArtikelColom.TEKST));
            Long datum = cursor.getLong(cursor.getColumnIndex(DatabaseInfo.ArtikelColom.DATUM));

            Artikel artikel = new Artikel(titel, tekst, datum, catagorie);
            artikelen.add(artikel);
        }
        return artikelen;
    }

    public void addArtikel(Artikel artikel)
    {
        ContentValues value = new ContentValues();
        value.put(DatabaseInfo.ArtikelColom.TITEL, artikel.getTitel());
        value.put(DatabaseInfo.ArtikelColom.CATAGORIE, artikel.getCatagorie());
        value.put(DatabaseInfo.ArtikelColom.DATUM, artikel.getDatum());
        value.put(DatabaseInfo.ArtikelColom.TEKST, artikel.getTekst());
        this.dbHelper.insert(DatabaseInfo.ArtikelTables.ARTIKELEN, null, value);
    }



}
