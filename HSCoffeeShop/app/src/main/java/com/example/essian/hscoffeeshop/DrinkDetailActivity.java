package com.example.essian.hscoffeeshop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DrinkDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_detail);

        int id = (Integer)getIntent().getExtras().get("drink type");
        Drink drink = Drink.drinks[id];

        TextView name = (TextView) findViewById(R.id.drinkName);
        name.setText(drink.getName());
    }
}
