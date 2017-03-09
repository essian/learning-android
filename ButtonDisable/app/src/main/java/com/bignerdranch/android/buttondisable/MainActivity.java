package com.bignerdranch.android.buttondisable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String BUTTON_CLICKED = "button clicked";
    private boolean mButtonClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            boolean buttonClicked = savedInstanceState.getBoolean(BUTTON_CLICKED);
            if (buttonClicked) {
//                What should go in here
            }
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.disable_me);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(false);
                button.setText("Disabled");
                mButtonClicked = true;

            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(BUTTON_CLICKED, mButtonClicked);
    }
}
