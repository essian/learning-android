package com.essian.android.quiz20;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    static final String STATE_NEEDLE_COUNT = "needleCount";
    int needle_count = 0;
    int score = 0;

    private TextView timGunnQuestionView;
    private String timGunnCorrectAnswer = "make it work";
    private EditText timGunnAnswer;

    private TextView treadleQuestionView;
    private String treadleCorrectAnswer = "treadle";
    private EditText treadleAnswer;

    private TextView big4QuestionView;
    private CheckBox simplicity;
    private CheckBox vogue;
    private CheckBox butterick;
    private CheckBox mccalls;
    private CheckBox burdastyle;
    private CheckBox kwiksew;
    private CheckBox burda;
    private CheckBox newlook;

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

    private TextView needle_quantity_view ;
    private Button mScore;
    private Button mIncrementNeedles;
    private Button mDecrementNeedles;
    private Button mResetButton;


    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_quiz, container, false);
    



            overlockerThreadsQuestionView = (TextView) v.findViewById(R.id.questionOverlockerThreads);
            overlockerThreadsAnswerView = (TextView) v.findViewById(R.id.needle_count);

        if (savedInstanceState != null) {
            needle_count = savedInstanceState.getInt(STATE_NEEDLE_COUNT);
        } else {
            needle_count = 0;
        }

        displayNeedleCount();

            needleEyeAnswer = (RadioButton) v.findViewById(R.id.needle_eye_tip);
            needleEyeQuestion = (TextView) v.findViewById(R.id.needleEye);

            bastingQuestionView = (TextView) v.findViewById(R.id.questionBasting);
            bastingCorrectAnswer = (RadioButton) v.findViewById(R.id.basting_true);

            electricMachineQuestionView = (TextView) v.findViewById(R.id.electricMachine);
            electricMachineAnswer = (EditText) v.findViewById(R.id.electric_machine_answer);

            timGunnQuestionView = (TextView) v.findViewById(R.id.timGunn);
            timGunnCorrectAnswer = "make it work";
            timGunnAnswer = (EditText) v.findViewById(R.id.tim_gunn_answer);

            treadleQuestionView = (TextView) v.findViewById(R.id.treadle);
            treadleCorrectAnswer = "treadle";
            treadleAnswer = (EditText) v.findViewById(R.id.treadle_answer);

            big4QuestionView = (TextView) v.findViewById(R.id.big4);
            simplicity = (CheckBox) v.findViewById(R.id.simplicity);
            vogue = (CheckBox) v.findViewById(R.id.vogue);
            butterick = (CheckBox) v.findViewById(R.id.butterick);
            mccalls = (CheckBox) v.findViewById(R.id.mccalls);
            burdastyle = (CheckBox) v.findViewById(R.id.burdastyle);
            kwiksew = (CheckBox) v.findViewById(R.id.kwiksew);
            burda = (CheckBox) v.findViewById(R.id.burda);
            newlook = (CheckBox) v.findViewById(R.id.newlook);

            mScore = (Button) v.findViewById(R.id.score_button);
            mScore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    score();
                }
            });
            mIncrementNeedles = (Button) v.findViewById(R.id.increment_needles);
            mIncrementNeedles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    needle_count += 1;
                    displayNeedleCount();
                }
            });

            mDecrementNeedles = (Button) v.findViewById(R.id.decrement_needles);
            mDecrementNeedles.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    needle_count -= 1;
                    displayNeedleCount();
                }
            });

            mResetButton = (Button) v.findViewById(R.id.reset_button);
            mResetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    restart();
                }
            });

            return v;
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
         */
       public void restart() {
           QuizFragment quiz = (QuizFragment) getFragmentManager().findFragmentById(R.id.fragment_container);
           getFragmentManager().beginTransaction()
                   .detach(quiz)
                   .attach(quiz)
                   .commit();
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
                Toast.makeText(getActivity(), R.string.invalid_needle_count, Toast.LENGTH_SHORT).show();
                return;
            }
            needle_count -= 1;
            displayNeedleCount();
        }

        /**
         * This method calculates the user's score, displays it then resets it.
         *
         *
         */
        public void score() {
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
            grade(result, overlockerThreadsQuestionView);
        }

        /**
         * This method increments the score if the answer to the question is correct
         */
        private void scoreQuestionBasting() {
            boolean result = bastingCorrectAnswer.isChecked();
            grade(result, bastingQuestionView);
        }


        /**
         * This method increments the score if the answer to the question is correct
         */
        private void scoreQuestionElectricMachine() {
            boolean result = electricMachineAnswer.getText().toString().toLowerCase().contains(electricMachineCorrectAnswer);
            grade(result, electricMachineQuestionView);
        }

        /**
         * This method increments the score if the answer to the question is correct
         */
        private void scoreQuestionNeedleEye() {
            boolean result = needleEyeAnswer.isChecked();
            grade(result, needleEyeQuestion);
        }

        /**
         * This method increments the score if the answer to the question is correct
         */
        private void scoreQuestionTimGunn() {
            boolean result = timGunnAnswer.getText().toString().toLowerCase().contains(timGunnCorrectAnswer);
            grade(result, timGunnQuestionView);
        }

        /**
         * This method increments the score if the answer to the question is correct
         */
        private void scoreQuestionTreadle() {
            String treadleTextAnswer = treadleAnswer.getText().toString().toLowerCase();
            boolean result = treadleTextAnswer.contains(treadleCorrectAnswer) || treadleTextAnswer.contains("treddle");
            grade(result, treadleQuestionView);
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
            grade(result, big4QuestionView);
        }

        /**
         * This method updates the displayed needle count
         */
        private void displayNeedleCount() {

            overlockerThreadsAnswerView.setText("" + needle_count);
        }

        /**
         * This method displays the users score in a toast message
         */
        private void displayScore() {
            String message = "You scored " + score;
            message += " out of 7";
            message += "\nWell done!";
            Toast toast = Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }

        /**
         * This method increments score and changes question text color depending on the result of the question
         *
         * @param result       is a boolean indicating if the answer was correct (true)
         * @param questionView is the textView that holds the question text
         */
        private void grade(boolean result, TextView questionView) {
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
            view.setTextColor(getColorWrapper(getContext(), R.color.colorCorrectAnswer));

        }

        /**
         * This method sets the text color of the passed in view to colorCorrectAnswer
         *
         * @param view is the current view
         */
        private void incorrectColor(TextView view) {
            view.setTextColor(getColorWrapper(getContext(), R.color.colorIncorrectAnswer));

        }

    public static int getColorWrapper(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            //noinspection deprecation
            return context.getResources().getColor(id);
        }
    }

}


