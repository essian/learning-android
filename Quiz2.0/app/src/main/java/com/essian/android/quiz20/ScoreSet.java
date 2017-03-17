package com.essian.android.quiz20;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import database.ScoreBaseHelper;
import database.ScoresDbSchema;

/**
 * Created by Essian on 17/03/2017.
 */

public class ScoreSet {
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public ScoreSet(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ScoreBaseHelper(mContext).getWritableDatabase();
    }

    public void addScore(Score score) {
        ContentValues values = getContentValues(score);
        mDatabase.insert(ScoresDbSchema.ScoreTable.NAME, null, values);
    }

    private static ContentValues getContentValues(Score score) {
        ContentValues values = new ContentValues();
        values.put(ScoresDbSchema.ScoreTable.Cols.NAME, score.getName());
        values.put(ScoresDbSchema.ScoreTable.Cols.SCORE, score.getScore());
        return values;
    }



}
