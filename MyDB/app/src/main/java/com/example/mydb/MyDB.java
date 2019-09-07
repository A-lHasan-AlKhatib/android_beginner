package com.example.mydb;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {

    public static final String DB_NAME = "Company";
    public static final String TABLE_NAME = "employee";
    public static final int DB_VERSION = 1;
    private static  final String COLUMN_ID = "id";
    private static  final String COLUMN_NAME = "name";
    private static  final String COLUMN_EMAIL = "email";

    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME +"("+ COLUMN_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , "
                + COLUMN_NAME + " TEXT NOT NULL , " + COLUMN_EMAIL + " TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertEmployee(Employee emp ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME,emp.getName());
        values.put(COLUMN_EMAIL,emp.getEmail());
        long result = db.insert(TABLE_NAME,null,values);
        return result > -1;
    }
}