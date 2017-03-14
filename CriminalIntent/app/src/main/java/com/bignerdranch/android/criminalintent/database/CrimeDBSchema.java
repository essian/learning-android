package com.bignerdranch.android.criminalintent.database;

/**
 * Created by Essian on 14/03/2017.
 */

public class CrimeDBSchema {
    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";
        }
    }
}
