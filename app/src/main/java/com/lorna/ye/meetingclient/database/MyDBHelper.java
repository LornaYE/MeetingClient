package com.jim.xun.meetingclient.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "myTest.db";

    public MyDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Users = "create table if not exists " + "Users" +
                " (Id integer primary key, CustomName text, OrderPrice integer, Country text)";
        sqLiteDatabase.execSQL(Users);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String Users = "DROP TABLE IF EXISTS " + "Users";
        sqLiteDatabase.execSQL(Users);
        onCreate(sqLiteDatabase);
    }

}
