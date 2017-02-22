package com.example.essian.basicclasses;

import android.util.Log;

/**
 * Created by Essian on 19/02/2017.
 */

public class Soldier {
    int health;
    String soldierType;

    void shootEnemy() {
        Log.i(soldierType, " is shooting");
    }
}
