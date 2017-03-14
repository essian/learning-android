package com.bignerdranch.android.criminalintent.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.bignerdranch.android.criminalintent.database.CrimeDBSchema.CrimeTable.NAME;
import static com.bignerdranch.android.criminalintent.database.CrimeDBSchema.CrimeTable.cols;

/**
 * Created by Essian on 14/03/2017.
 */

public class CrimeBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimebase.db";

    public CrimeBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + NAME + "(" +
        cols.UUID + ", " +
        cols.TITLE + ", " +
        cols.DATE + ", " +
        cols.SOLVED + ", " +
                        cols.SUSPECT +
        ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
