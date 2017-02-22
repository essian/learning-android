package com.example.essian.inheritanceexample;

import android.util.Log;

/**
 * Created by Essian on 20/02/2017.
 */

public class Fighter extends AlienShip{

    public Fighter(){
        super(400);
        // Strong shields for a fighter
        Log.i("Location: ", "Fighter constructor");
    }

    public void fireWeapon(){
        Log.i("Firing weapon: ", "lasers firing");
    }

}