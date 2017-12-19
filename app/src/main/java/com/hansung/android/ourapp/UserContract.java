package com.hansung.android.ourapp;



import android.provider.BaseColumns;

public final class UserContract {
    public static final String DB_NAME="user.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserContract() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME="Users";
        public static final String TABLE_NAME2="Users2";
        public static final String KEY_NAME = "Name";
        public static final String KEY_ADRESS = "Adress";
        public static final String KEY_NUMBER = "Number";
        public static final String KEY_PRICE = "Price";
        public static final String KEY_DETAIL = "Detail";
        public static final String KEY_IMGNAME = "Imgname";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY"+ COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_ADRESS + TEXT_TYPE + COMMA_SEP +
                KEY_NUMBER + TEXT_TYPE + COMMA_SEP +
                KEY_IMGNAME + TEXT_TYPE +" )";

        public static final String CREATE_TABLE2 = "CREATE TABLE " + TABLE_NAME2 + " (" +
                _ID + " INTEGER PRIMARY KEY"+ COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_PRICE + TEXT_TYPE + COMMA_SEP +
                KEY_DETAIL + TEXT_TYPE + COMMA_SEP +
                KEY_IMGNAME + TEXT_TYPE +" )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
