package com.example.tabslay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "RESTAURANT";
    public static final String TABLE_NAME = "MENU_CATEGORIES";
    private static final int DB_VERSION = 1;
    public static final String COLUMN_ID = "Id";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_DESC = "Description";


    public MyDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + COLUMN_NAME + " TEXT NOT NULL , " + COLUMN_DESC + " TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertCatrgoy(Catrgoy catrgoy) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, catrgoy.getId());
        values.put(COLUMN_NAME, catrgoy.getName());
        values.put(COLUMN_DESC, catrgoy.getDesc());
        return db.insert(TABLE_NAME, null, values) > -1;
    }

    public long getCarsCount() {
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }

    public ArrayList<Catrgoy> getAllCats() {
        ArrayList<Catrgoy> cats = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex(COLUMN_ID));
                String name = c.getString(c.getColumnIndex(COLUMN_NAME));
                String desc = c.getString(c.getColumnIndex(COLUMN_DESC));
                Catrgoy cat = new Catrgoy(id, name, desc);
                cats.add(cat);
            } while (c.moveToNext());
            c.close();
        }
        return cats;
    }

}
