package com.example.yanick.politieapp.Database;

import android.content.Context;
import android.content.ContentValues;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by 0x000000 on 3-1-2018.
 */

//TODO:         Try/Catch alles, zodat applicatie niet crasht!

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String dbName = "artikel.db";
    public static final int dbVersion = 1;
    public static SQLiteDatabase mSQLDB;
    private static DatabaseHelper mInstance;


    public DatabaseHelper(Context ctx) {
        super(ctx, dbName, null, dbVersion);
    }

    public DatabaseHelper(Context context, String name,
                          SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized DatabaseHelper getHelper(Context ctx) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(ctx);
            mSQLDB = mInstance.getWritableDatabase();
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DatabaseInfo.ArtikelTables.ARTIKELEN + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseInfo.ArtikelColom.TITEL + " TEXT," +
                DatabaseInfo.ArtikelColom.DATUM + " LONG," +
                DatabaseInfo.ArtikelColom.CATAGORIE + " TEXT," +
                DatabaseInfo.ArtikelColom.TEKST + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DatabaseInfo.ArtikelTables.ARTIKELEN);
        onCreate(db);
    }

    public void insert(String table, String nullColumnHack, ContentValues
            values) {
        mSQLDB.insert(table, nullColumnHack, values);
    }

    public Cursor query(String table, String[] columns, String selection,
                        String[] selectArgs, String groupBy, String having, String orderBy) {
        return mSQLDB.query(table, columns, selection, selectArgs, groupBy,
                having, orderBy);
    }
}
