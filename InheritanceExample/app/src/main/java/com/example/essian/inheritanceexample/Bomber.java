package com.example.essian.inheritanceexample;

import android.util.Log;

/**
 * Created by Essian on 20/02/2017.
 */

public class Bomber extends AlienShip {

    public Bomber() {
        super(100);
        Log.i("Location: ", "Bomber constructor");
    }

    public void fireWeapon() {
        Log.i("Firing weapon: ", "bombs away");
    }
}
