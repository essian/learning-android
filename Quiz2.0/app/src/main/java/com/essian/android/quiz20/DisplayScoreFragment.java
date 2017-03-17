package com.essian.android.quiz20;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by Essian on 17/03/2017.
 */

public class DisplayScoreFragment extends DialogFragment {

    private static final String ARG_SCORE = "score";
    private static final String ARG_NAME = "name";

    public static DisplayScoreFragment newInstance(int score, String name) {
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_SCORE, score);

        DisplayScoreFragment fragment = new DisplayScoreFragment();
        fragment.setArguments(args);
        return fragment;
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int score = getArguments().getInt(ARG_SCORE);
        String name = getArguments().getString(ARG_NAME);
        String message = "Well done " + name
                + "! You scored " + score + " " + getResources().getQuantityString(R.plurals.point, score) +"."
                + "\n\nDo you want to save your score or retry and change your answers?";
        return new AlertDialog.Builder(getActivity())
                .setTitle("Your Score")
                .setMessage(message)
                .setPositiveButton(R.string.save, null)
                .setNegativeButton(R.string.retry, null)
                .create();
    }
}
