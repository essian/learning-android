package com.essian.android.quiz20;

/**
 * Created by Essian on 17/03/2017.
 */

public class Score {

    private String mName;
    private int mScore;


    public Score(String name, int score) {
        mName = name;
        mScore = score;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

}
