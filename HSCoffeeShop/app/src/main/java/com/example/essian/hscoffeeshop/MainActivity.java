package com.example.essian.hscoffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent drinkIntent = new Intent(MainActivity.this, DrinksActivity.class);
                    startActivity(drinkIntent);
                }
            }
        };

        ListView menu = (ListView) findViewById(R.id.listView);
        menu.setOnItemClickListener(listener);
    }
}
