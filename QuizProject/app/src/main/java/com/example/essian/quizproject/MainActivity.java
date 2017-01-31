package com.example.essian.quizproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app display a set of quiz questions and provides the user with a score when they submit
 * their answers.
 */
public class MainActivity extends AppCompatActivity {

    static final String STATE_NEEDLE_COUNT = "needleCount";
    int needle_count = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            needle_count = savedInstanceState.getInt(STATE_NEEDLE_COUNT);
        } else {
            needle_count = 0;
        }
        setContentView(R.layout.activity_main);
        displayNeedleCount();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current state
        savedInstanceState.putInt(STATE_NEEDLE_COUNT, needle_count);


        // call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This method restarts mainActivity resulting in the answers and scores being reset
     * @param v is the current view
     */
    public void restart(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * This method increments the needle count by 1 and updates the display with the new value
     * @param v is the current view
     */
    public void increment(View v) {
        needle_count += 1;
        displayNeedleCount();
    }

    /**
     * This method decrements the needle count by 1 and updates the display with the new value
     * @param v is the current view.
     */
    public void decrement(View v) {
        if (needle_count <=0) {
            Toast.makeText(this, R.string.invalid_needle_count, Toast.LENGTH_SHORT).show();
            return;
        }
        needle_count -= 1;
        displayNeedleCount();
    }

    /**
     * This method calculates the user's score, displays it then resets it.
     * @param v is the current view
     */
    public void score(View v) {
        scoreQuestionOverlockerThreads();
        scoreQuestionBasting();
        scoreQuestionElectricMachine();
        scoreQuestionNeedleEye();
        scoreQuestionTimGunn();
        scoreQuestionTreadle();
        scoreQuestionBig4();
        displayScore();
        score = 0;
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionOverlockerThreads() {
        String correctAnswer = "2";
        TextView answerView = (TextView) findViewById(R.id.needle_count);
        if (answerView.getText().equals(correctAnswer)) {
            score +=1;
        }

    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionBasting() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.basting_true);
        if (correctAnswer.isChecked()) {
            score += 1;
        }
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionElectricMachine() {
        String correctAnswer = "singer";
        EditText answer = (EditText) findViewById(R.id.electric_machine_answer);
        if (answer.getText().toString().toLowerCase().contains(correctAnswer)) {
            score += 1;
        }
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionNeedleEye() {
        RadioButton correctAnswer = (RadioButton) findViewById(R.id.needle_eye_tip);
        if (correctAnswer.isChecked()) {
            score += 1;
        }
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionTimGunn() {
        String correctAnswer = "make it work";
        EditText answer = (EditText) findViewById(R.id.tim_gunn_answer);
        if (answer.getText().toString().toLowerCase().contains(correctAnswer)) {
            score += 1;
        }
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionTreadle() {
        String correctAnswer = "treadle";
        EditText answer = (EditText) findViewById(R.id.treadle_answer);
        String text_answer = answer.getText().toString().toLowerCase();
        if (text_answer.contains(correctAnswer) || text_answer.contains("treddle")) {
            score += 1;
        }
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionBig4() {
        CheckBox simplicity = (CheckBox) findViewById(R.id.simplicity);
        CheckBox vogue = (CheckBox) findViewById(R.id.vogue);
        CheckBox butterick = (CheckBox) findViewById(R.id.butterick);
        CheckBox mccalls = (CheckBox) findViewById(R.id.mccalls);
        CheckBox burdastyle = (CheckBox) findViewById(R.id.burdastyle);
        CheckBox kwiksew = (CheckBox) findViewById(R.id.kwiksew);
        CheckBox burda = (CheckBox) findViewById(R.id.burda);
        CheckBox newlook = (CheckBox) findViewById(R.id.newlook);

        Boolean allRightAnswers = simplicity.isChecked() &&
                                    vogue.isChecked() &&
                                    butterick.isChecked() &&
                                    mccalls.isChecked();
        Boolean anyWrongAnswers = burdastyle.isChecked() ||
                                    kwiksew.isChecked() ||
                                    burda.isChecked() ||
                                    newlook.isChecked();
        if (allRightAnswers && !anyWrongAnswers) {
            score += 1;
        }
    }

    /**
     * This method updates the displayed needle count
     */
    private void displayNeedleCount() {
        TextView needle_quantity_view = (TextView) findViewById(R.id.needle_count);
        needle_quantity_view.setText(("" + needle_count));
    }

    /**
     * This method displays the users score in a toast message
     */
    private void displayScore() {
        String message = "You scored " + score;
        message += " out of 7";
        message += "\nWell done!";
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0 , 0);
        toast.show();
    }

}
