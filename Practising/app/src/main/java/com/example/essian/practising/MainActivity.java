package com.example.essian.practising;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView textView = new TextView(this);
        textView.setText("Wow!\nThis is waaay cool\nDon't ya think");
        textView.setTextColor(Color.CYAN);
        textView.setTextSize(24);
        textView.setAllCaps(true);
        textView.setMaxLines(2);
        setContentView(textView);

    }
}
