package com.sivapurni.myhealthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
public class DBHelper extends SQLiteOpenHelper {
    public static final int DBVER=1;
    public static final String DBNAME="healthDB";
    public static final String TABLEDIR="BPRecord";
    public static final String COLDATE="Date";
    public static final String COLTIME="Time";
    public static final String COLSYSTOLIC="Systolic";
    public static final String COLDIASTOLIC="Diastolic";
    public static final String COLBPSTATUS="BPStatus";

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVER);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    public int count() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLEDIR;
        int recordCount = db.rawQuery(sql,
                null).getCount();
        db.close();
        return recordCount;
    }
    // reading all the directory.
    public ArrayList<dirModal> readDir() {
        // obj to read our database.
        SQLiteDatabase db = this.getReadableDatabase();
        // creating a cursor with query to read data from table
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLEDIR, null);
        //create a new array list.
        ArrayList<dirModal> dirModalArrayList = new ArrayList<>();
        // move cursor to first position.
        if (cursor.moveToFirst()) {
            do {
                // adding the data from cursor to our array list.
                dirModalArrayList.add(new dirModal(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getInt(3),
                        cursor.getInt(4)));
            } while (cursor.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursor.close();
        return dirModalArrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int newVer, int oldVer) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLEDIR);
        onCreate(db);
    }
}
