package com.example.essian.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView mango = (TextView) findViewById(R.id.menu_item_1);
        TextView blueberry = (TextView) findViewById(R.id.menu_item_2);
        TextView chocolate = (TextView) findViewById(R.id.menu_item_3);
        String text1 = mango.getText().toString();
        String text2 = (String) blueberry.getText();
        String text3 = (String) chocolate.getText();
        Log.i("MainActivity", text1);
        Log.i("MainActivity", text2);
        Log.i("MainActivity", text3);

        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs

    }
}