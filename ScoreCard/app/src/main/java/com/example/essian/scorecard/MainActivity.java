package com.example.essian.scorecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int jessScore = 0;
    int seanScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jessAddOne(View v){
        jessScore = jessScore + 1;
        displayJessScore(jessScore);
    }

    public void jessMinusOne(View v){
        jessScore = jessScore - 1;
        displayJessScore(jessScore);
    }

    public void jessDoubleUp(View v) {
        jessScore = jessScore * 2;
        displayJessScore(jessScore);
    }


    public void seanAddOne(View v){
        seanScore = seanScore + 1;
        displaySeanScore(seanScore);
    }

    public void seanMinusOne(View v){
        seanScore = seanScore - 1;
        displaySeanScore(seanScore);
    }

    public void seanDoubleUp(View v) {
        seanScore = seanScore * 2;
        displaySeanScore(seanScore);
    }

    public void resetScores(View v) {
        jessScore = 0;
        seanScore = 0;
        displaySeanScore(seanScore);
        displayJessScore(jessScore);
    }

    private void displayJessScore (int score) {

        TextView scoreView = (TextView) findViewById(R.id.jess_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displaySeanScore (int score) {
        TextView scoreView = (TextView) findViewById(R.id.sean_score);
        scoreView.setText(String.valueOf(score));
    }
}
