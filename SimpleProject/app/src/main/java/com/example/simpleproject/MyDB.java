package com.example.simpleproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDB extends SQLiteOpenHelper {

    public static final String CAR_DB_NAME = "cars";
    public static final String CAR_TABLE_NAME = "car";
    public static final int DB_VERSION = 1;
    private static final String COL_ID = "id";
    private static final String COL_MODEL = "model";
    private static final String COL_COLOR = "color";
    private static final String COL_DPL = "distancePerLetter";
    private static final String COL_IMG = "img";
    private static final String COL_DESC = "description";

    public MyDB(Context context) {
        super(context, CAR_DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + CAR_TABLE_NAME + " ( " + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COL_MODEL + " TEXT, " + COL_COLOR + " TEXT, " + COL_DPL + " REAL, "+ COL_DESC + " TEXT, " +COL_IMG + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertCar(Car c) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_MODEL, c.getModel());
        values.put(COL_COLOR, c.getColor());
        values.put(COL_DPL, c.getDpl());
        values.put(COL_DESC, c.getDescription());
        values.put(COL_IMG, c.getImg());

        return db.insert(CAR_TABLE_NAME, null, values) != -1;
    }

    public boolean updateCar(Car c) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COL_MODEL, c.getModel());
        values.put(COL_COLOR, c.getColor());
        values.put(COL_DPL, c.getDpl());
        values.put(COL_DESC, c.getDescription());
        values.put(COL_IMG, c.getImg());
        return db.update(CAR_TABLE_NAME, values, "id = ? ", new String[]{String.valueOf(c.getId())}) > 0;
    }

    public long getCarsCount() {
        SQLiteDatabase db = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, CAR_TABLE_NAME);
    }

    public boolean deleteCar(Car c) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(CAR_TABLE_NAME, "id = ?", new String[]{String.valueOf(c.getId())}) > 0;
    }

    public ArrayList<Car> getAllCars() {
        ArrayList<Car> cars = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CAR_TABLE_NAME, null);
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex(COL_ID));
                String model = c.getString(c.getColumnIndex(COL_MODEL));
                String color = c.getString(c.getColumnIndex(COL_COLOR));
                String img = c.getString(c.getColumnIndex(COL_IMG));
                String desc = c.getString(c.getColumnIndex(COL_DESC));
                double dpl = c.getDouble(c.getColumnIndex(COL_DPL));
                Car car = new Car(id, model, color, dpl,img,desc);
                cars.add(car);
            } while (c.moveToNext());
            c.close();
        }
        return cars;
    }

    public ArrayList<Car> getCarsByModel(String modelSearch) {
        ArrayList<Car> cars = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CAR_TABLE_NAME + " WHERE " + COL_MODEL + " LIKE ?", new String[]{"%" + modelSearch + "%"});
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex(COL_ID));
                String model = c.getString(c.getColumnIndex(COL_MODEL));
                String color = c.getString(c.getColumnIndex(COL_COLOR));
                String img = c.getString(c.getColumnIndex(COL_IMG));
                String desc = c.getString(c.getColumnIndex(COL_DESC));
                double dpl = c.getDouble(c.getColumnIndex(COL_DPL));
                Car car = new Car(id, model, color, dpl,img,desc);
                cars.add(car);
            } while (c.moveToNext());
            c.close();
        }
        return cars;
    }

    public Car getCar(int searchId) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CAR_TABLE_NAME + " WHERE " + COL_ID + " = ?", new String[]{String.valueOf(searchId)});
        if (c.moveToFirst()) {
                int id = c.getInt(c.getColumnIndex(COL_ID));
                String model = c.getString(c.getColumnIndex(COL_MODEL));
                String color = c.getString(c.getColumnIndex(COL_COLOR));
                String img = c.getString(c.getColumnIndex(COL_IMG));
                String desc = c.getString(c.getColumnIndex(COL_DESC));
                double dpl = c.getDouble(c.getColumnIndex(COL_DPL));
                Car car = new Car(id, model, color, dpl,img,desc);
            c.close();
            return car;
        }
        return null;
    }

}