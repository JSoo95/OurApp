package com.hansung.android.ourapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    final static String TAG="SQLiteDBTest";

    public DBHelper(Context context) {
        super(context, UserContract.DB_NAME, null, UserContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,getClass().getName()+".onCreate()");
        db.execSQL(UserContract.Users.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG,getClass().getName() +".onUpgrade()");
        db.execSQL(UserContract.Users.DELETE_TABLE);
        onCreate(db);
    }

    public void insertUserBySQL(String name, String adress, String number) {
        try {
            String sql = String.format (
                    "INSERT INTO %s (%s, %s, %s) VALUES ('%s', '%s', '%s')",
                    UserContract.Users.TABLE_NAME,
                    UserContract.Users.KEY_NAME,
                    UserContract.Users.KEY_ADRESS,
                    UserContract.Users.KEY_NUMBER,
                    name,
                    adress,
                    number);

            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG,"Error in inserting recodes");
        }
    }

    public Cursor getAllUsersBySQL() {
        String sql = "Select * FROM " + UserContract.Users.TABLE_NAME;
        return getReadableDatabase().rawQuery(sql,null);
    }

    public void deleteUserBySQL(String name) {
        try {
            String sql = String.format (
                    "DELETE FROM %s WHERE %s = %s",
                    UserContract.Users.TABLE_NAME,
                    UserContract.Users.KEY_NAME,
                    name);
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG,"Error in deleting recodes");
        }
    }

    public void updateUserBySQL(String _id, String name, String adress, String number) {
        try {
            String sql = String.format (
                    "UPDATE  %s SET %s = '%s', %s = '%s', %s = '%s' WHERE %s = %s",
                    UserContract.Users.TABLE_NAME,
                    UserContract.Users.KEY_NAME, name,
                    UserContract.Users.KEY_ADRESS, adress,
                    UserContract.Users.KEY_NUMBER, number,
                    UserContract.Users.KEY_NAME, name) ;
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG,"Error in updating recodes");
        }
    }

    public long insertUserByMethod(String name, String adress, String number) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserContract.Users.KEY_NAME, name);
        values.put(UserContract.Users.KEY_ADRESS,adress);
        values.put(UserContract.Users.KEY_NUMBER,number);

        return db.insert(UserContract.Users.TABLE_NAME,null,values);
    }

    public Cursor getAllUsersByMethod() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(UserContract.Users.TABLE_NAME,null,null,null,null,null,null);
    }

    public long deleteUserByMethod(String name) {
        SQLiteDatabase db = getWritableDatabase();

        String whereClause = UserContract.Users.KEY_NAME +" = ?";
        String[] whereArgs ={name};
        return db.delete(UserContract.Users.TABLE_NAME, whereClause, whereArgs);
    }

    public long updateUserByMethod(String name, String adress, String number) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.Users.KEY_NAME, name);
        values.put(UserContract.Users.KEY_ADRESS,adress);
        values.put(UserContract.Users.KEY_ADRESS,number);

        String whereClause = UserContract.Users.KEY_NAME +" = ?";
        String[] whereArgs ={name};

        return db.update(UserContract.Users.TABLE_NAME, values, whereClause, whereArgs);
    }

}