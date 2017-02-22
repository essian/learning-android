package com.example.essian.inheritanceexample;

import android.util.Log;

/**
 * Created by Essian on 20/02/2017.
 */

public abstract class AlienShip {
    private static int numShips;
    private int shieldStrength;
    public String shipName;

    public AlienShip(int shieldStrength) {
        Log.i("Location: ", "AlienShip constructor");
        numShips++;
        this.shieldStrength = shieldStrength;
    }

    public abstract void fireWeapon();

    public static int getNumShips() {
        return numShips;
    }

    public void setShieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength() {
        return shieldStrength;
    }

    public void hitDetected() {
        shieldStrength -= 25;
        Log.i("Incoming: ", "Bam!!");
        if (shieldStrength == 0){
            destroyShip();
        }
    }

    private void destroyShip() {
        numShips--;
        Log.i("Explosion: ", "" + this.shipName + " destroyed");
    }
}
