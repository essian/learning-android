package com.example.essian.hscoffeeshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.example.essian.hscoffeeshop.R.id.drinksList;

public class DrinksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        ListView drinksListView = (ListView) findViewById(drinksList);

        ArrayAdapter<Drink> drinksListAdapter = new ArrayAdapter<Drink>(this, android.R.layout.simple_list_item_1, Drink.drinks);

        drinksListView.setAdapter(drinksListAdapter);

        AdapterView.OnItemClickListener drinksListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinksActivity.this, DrinkDetailActivity.class);
                intent.putExtra("drink type", (int) id);
                startActivity(intent);
            }
        };

        drinksListView.setOnItemClickListener(drinksListener);
    }
}
