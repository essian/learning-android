package com.example.essian.quizproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.essian.quizproject.R.id.needleEye;


/**
 * This app display a set of quiz questions and provides the user with a score when they submit
 * their answers.
 */
public class MainActivity extends AppCompatActivity {

    static final String STATE_NEEDLE_COUNT = "needleCount";
    int needle_count = 0;
    int score = 0;
    TextView timGunnQuestionView;
    String timGunnCorrectAnswer = "make it work";
    EditText timGunnAnswer;
    TextView treadleQuestionView;
    String treadleCorrectAnswer = "treadle";
    EditText treadleAnswer;
    TextView big4QuestionView;
    CheckBox simplicity;
    CheckBox vogue;
    CheckBox butterick;
    CheckBox mccalls;
    CheckBox burdastyle;
    CheckBox kwiksew;
    CheckBox burda;
    CheckBox newlook;
    private TextView needleEyeQuestion;
    private RadioButton needleEyeAnswer;
    private TextView overlockerThreadsQuestionView;
    private TextView overlockerThreadsAnswerView;
    private String overlockerThreadsCorrectAnswer = "2";
    private TextView bastingQuestionView;
    private RadioButton bastingCorrectAnswer;
    private TextView electricMachineQuestionView;
    private String electricMachineCorrectAnswer = "singer";
    private EditText electricMachineAnswer;

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

        overlockerThreadsQuestionView = (TextView) findViewById(R.id.questionOverlockerThreads);
        overlockerThreadsAnswerView = (TextView) findViewById(R.id.needle_count);

        needleEyeAnswer = (RadioButton) findViewById(R.id.needle_eye_tip);
        needleEyeQuestion = (TextView) findViewById(R.id.needleEye);

        bastingQuestionView = (TextView) findViewById(R.id.questionBasting);
        bastingCorrectAnswer = (RadioButton) findViewById(R.id.basting_true);

        electricMachineQuestionView = (TextView) findViewById(R.id.electricMachine);
        electricMachineAnswer = (EditText) findViewById(R.id.electric_machine_answer);

        timGunnQuestionView = (TextView) findViewById(R.id.timGunn);
        timGunnCorrectAnswer = "make it work";
        timGunnAnswer = (EditText) findViewById(R.id.tim_gunn_answer);

        treadleQuestionView = (TextView) findViewById(R.id.treadle);
        treadleCorrectAnswer = "treadle";
        treadleAnswer = (EditText) findViewById(R.id.treadle_answer);

        big4QuestionView = (TextView) findViewById(R.id.big4);
        simplicity = (CheckBox) findViewById(R.id.simplicity);
        vogue = (CheckBox) findViewById(R.id.vogue);
        butterick = (CheckBox) findViewById(R.id.butterick);
        mccalls = (CheckBox) findViewById(R.id.mccalls);
        burdastyle = (CheckBox) findViewById(R.id.burdastyle);
        kwiksew = (CheckBox) findViewById(R.id.kwiksew);
        burda = (CheckBox) findViewById(R.id.burda);
        newlook = (CheckBox) findViewById(R.id.newlook);
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
     *
     * @param v is the current view
     */
    public void restart(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    /**
     * This method increments the needle count by 1 and updates the display with the new value
     *
     * @param v is the current view
     */
    public void increment(View v) {
        needle_count += 1;
        displayNeedleCount();
    }

    /**
     * This method decrements the needle count by 1 and updates the display with the new value
     *
     * @param v is the current view.
     */
    public void decrement(View v) {
        if (needle_count <= 0) {
            Toast.makeText(this, R.string.invalid_needle_count, Toast.LENGTH_SHORT).show();
            return;
        }
        needle_count -= 1;
        displayNeedleCount();
    }

    /**
     * This method calculates the user's score, displays it then resets it.
     *
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
        boolean result = overlockerThreadsAnswerView.getText().equals(overlockerThreadsCorrectAnswer);
        updateScoreAndDisplay(result, overlockerThreadsQuestionView);
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionBasting() {
        boolean result = bastingCorrectAnswer.isChecked();
        updateScoreAndDisplay(result, bastingQuestionView);
    }


    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionElectricMachine() {
        boolean result = electricMachineAnswer.getText().toString().toLowerCase().contains(electricMachineCorrectAnswer);
        updateScoreAndDisplay(result, electricMachineQuestionView);
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionNeedleEye() {
        boolean result = needleEyeAnswer.isChecked();
        updateScoreAndDisplay(result, needleEyeQuestion);
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionTimGunn() {
        boolean result = timGunnAnswer.getText().toString().toLowerCase().contains(timGunnCorrectAnswer);
        updateScoreAndDisplay(result, timGunnQuestionView);
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionTreadle() {
        String treadleTextAnswer = treadleAnswer.getText().toString().toLowerCase();
        boolean result = treadleTextAnswer.contains(treadleCorrectAnswer) || treadleTextAnswer.contains("treddle");
        updateScoreAndDisplay(result, treadleQuestionView);
    }

    /**
     * This method increments the score if the answer to the question is correct
     */
    private void scoreQuestionBig4() {
        Boolean allRightAnswers = simplicity.isChecked() &&
                vogue.isChecked() &&
                butterick.isChecked() &&
                mccalls.isChecked();
        Boolean anyWrongAnswers = burdastyle.isChecked() ||
                kwiksew.isChecked() ||
                burda.isChecked() ||
                newlook.isChecked();
        boolean result = allRightAnswers && !anyWrongAnswers;
        updateScoreAndDisplay(result, big4QuestionView);
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
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * This method increments score and changes question text color depending on the result of the question
     *
     * @param result       is a boolean indicating if the answer was correct (true)
     * @param questionView is the textView that holds the question text
     */
    private void updateScoreAndDisplay(boolean result, TextView questionView) {
        if (result) {
            score += 1;
            correctColor(questionView);
        } else {
            incorrectColor(questionView);
        }
    }

    /**
     * This method sets the text color of the passed in view to colorCorrectAnswer
     *
     * @param view is the current view
     */
    private void correctColor(TextView view) {
        view.setTextColor(getColor(R.color.colorCorrectAnswer));

    }

    /**
     * This method sets the text color of the passed in view to colorCorrectAnswer
     *
     * @param view is the current view
     */
    private void incorrectColor(TextView view) {
        view.setTextColor(getColor(R.color.colorIncorrectAnswer));

    }

}
