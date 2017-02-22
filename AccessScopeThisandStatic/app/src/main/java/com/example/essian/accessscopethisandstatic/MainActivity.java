package com.example.essian.accessscopethisandstatic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlienShip girl = new AlienShip();
        AlienShip boy = new AlienShip();

        Log.i("Ships: ", "" + AlienShip.getNumShips());

        girl.shipName = "Jess";
        boy.shipName = "Sean";

        Log.i("girl shieldStrngth: ", "" + girl.getShieldStrength());

        Log.i("boy shieldStrngth: ", "" + boy.getShieldStrength());

    }
}
