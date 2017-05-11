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

    static final String STATE_PLAYER1_SCORE = "player1Score";
    static final String STATE_PLAYER2_SCORE = "player2Score";
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
        displayScore(player1Score, 1);
        displayScore(player2Score, 2);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_PLAYER1_SCORE, player1Score);
        savedInstanceState.putInt(STATE_PLAYER2_SCORE, player2Score);


        // call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void addOne(View v) {
        int player = Integer.parseInt(v.getTag().toString());

        if (player == 1) {
            player1Score += 1;
            displayScore(player1Score, player);
        } else {
            player2Score += 1;
            displayScore(player2Score, player);
        }
        blinkImage(1);
    }

    public void subtractOne(View v) {
        int player = Integer.parseInt(v.getTag().toString());

        if (player == 1) {
            player1Score -= 1;
            displayScore(player1Score, player);
        } else {
            player2Score -= 1;
            displayScore(player2Score, player);
        }
    }

    public void doubleUp(View v) {
        int player = Integer.parseInt(v.getTag().toString());
        if (player == 1 && player1Score > 0) {
            blinkImage(player1Score);
            player1Score = player1Score * 2;
            displayScore(player1Score, 1);
        } else if (player == 2 && player2Score > 0) {
            blinkImage(player2Score);
            player2Score = player2Score * 2;
            displayScore(player2Score, 2);
        } else {
            Toast.makeText(this, R.string.only_positive_doubled, Toast.LENGTH_SHORT).show();
        }
    }


    public void resetScores() {
        player1Score = 0;
        player2Score = 0;
        displayScore(player2Score, 2);
        displayScore(player1Score, 1);
    }

    private void displayScore(int score, int player) {
        TextView scoreViewP1 = (TextView) findViewById(R.id.player1_score);
        TextView scoreViewP2 = (TextView) findViewById(R.id.player2_score);
        if (player == 1) {
            scoreViewP1.setText(String.valueOf(score));
        } else {
            scoreViewP2.setText(String.valueOf(score));
        }
    }


    private void blinkImage(int count) {
        ImageView mainImage = (ImageView) findViewById(R.id.main_image);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(80); //You can manage the time of the blink with this parameter
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(count - 1);
        mainImage.startAnimation(anim);
    }
}
