package com.essian.android.fragmentpractice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        Fragment secondFragment = fm.findFragmentById(R.id.container);
        if (secondFragment == null) {
            secondFragment = SecondFragment.newInstance("hello", "jessy");
            fm.beginTransaction().add(R.id.container, secondFragment).commit();

        }

    }
}



