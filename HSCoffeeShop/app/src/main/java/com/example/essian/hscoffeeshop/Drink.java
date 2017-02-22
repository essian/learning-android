package com.example.essian.hscoffeeshop;

/**
 * Created by Essian on 22/02/2017.
 */

public class Drink {

    private String mName;
    private String mDescription;

    public Drink(String description, String name) {
        this.mDescription = description;
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String toString() {
        return this.mName;
    }

    public static final Drink[] drinks = {
            new Drink("milky coffee", "latte"),
            new Drink("foamy coffee", "capuccino"),
            new Drink("black coffee", "espresso")
    };
}
