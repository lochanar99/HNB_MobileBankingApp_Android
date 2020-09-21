package com.example.uee_banking_app_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "Banking.db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE IF NOT EXISTS users (" +
                    "username VARCHAR(30) PRIMARY KEY," +
                    "password VARCHAR(30) " +
                    ")" +
                "");

        db.execSQL("INSERT INTO users VALUES('admin','admin')");
        db.execSQL("INSERT INTO users VALUES('John Doe','thanos')");
        db.execSQL("INSERT INTO users VALUES('abi','abi')");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        //  db.execSQL("DROP TABLE IF EXISTS online");
        //  db.execSQL("DROP TABLE IF EXISTS settings");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
