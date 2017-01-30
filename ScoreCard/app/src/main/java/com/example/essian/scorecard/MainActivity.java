package com.example.essian.scorecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player1Score = 0;
    int player2Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            player1Score = savedInstanceState.getInt(STATE_PLAYER1_SCORE);
            player2Score = savedInstanceState.getInt(STATE_PLAYER2_SCORE);
        } else {
            player1Score = 0;
            player2Score = 0;
        }
        setContentView(R.layout.activity_main);
        displayPlayer1Score(player1Score);
        displayPlayer2Score(player2Score);
    }

    static final String STATE_PLAYER1_SCORE = "player1Score";
    static final String STATE_PLAYER2_SCORE = "player2Score";

            @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_PLAYER1_SCORE, player1Score);
        savedInstanceState.putInt(STATE_PLAYER2_SCORE, player2Score);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void player1AddOne(View v){
        player1Score = player1Score + 1;
        displayPlayer1Score(player1Score);
        blinkImage(1);
    }

    public void player1MinusOne(View v){
        player1Score = player1Score - 1;
        displayPlayer1Score(player1Score);
    }

    public void player1DoubleUp(View v) {
        if (player1Score > 0) {
            blinkImage(player1Score);
            player1Score = player1Score * 2;
            displayPlayer1Score(player1Score);
            return;
        }
        Toast.makeText(this, R.string.only_positive_doubled, Toast.LENGTH_SHORT).show();
    }


    public void player2AddOne(View v){
        player2Score = player2Score + 1;
        displayPlayer2Score(player2Score);
        blinkImage(1);
    }

    public void player2MinusOne(View v){
        player2Score = player2Score - 1;
        displayPlayer2Score(player2Score);
    }

    public void player2DoubleUp(View v) {
        if (player2Score > 0) {
            blinkImage(player2Score);
            player2Score = player2Score * 2;
            displayPlayer2Score(player2Score);
            return;
        }
        Toast.makeText(this, R.string.only_positive_doubled, Toast.LENGTH_SHORT).show();
    }

    public void resetScores(View v) {
        player1Score = 0;
        player2Score = 0;
        displayPlayer2Score(player2Score);
        displayPlayer1Score(player1Score);
    }

    private void displayPlayer1Score(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player1_score);
        scoreView.setText(String.valueOf(score));
    }

    private void displayPlayer2Score (int score) {
        TextView scoreView = (TextView) findViewById(R.id.player2_score);
        scoreView.setText(String.valueOf(score));
    }

    private void blinkImage(int count) {
        ImageView mainImage = (ImageView) findViewById(R.id.main_image);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(80); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(count-1);
        mainImage.startAnimation(anim);
    }
}
