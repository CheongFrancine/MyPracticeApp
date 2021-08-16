package sg.edu.rp.c346.id20020509.mypracticeapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "practice.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRACTICE = "Practice";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_STARS = "stars";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE Practice
        // (id INTEGER PRIMARY KEY AUTOINCREMENT, description TEXT,
        // stars INTEGER);
        String createPracticeTableSql = "CREATE TABLE " + TABLE_PRACTICE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_DESCRIPTION + " TEXT, "
                + COLUMN_STARS + " INTEGER )";
        db.execSQL(createPracticeTableSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRACTICE);
        onCreate(db);
    }

    public long insertPractice(String description, int stars) {
        // Get an instance of the database for writing
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_STARS, stars);
        // Insert the row into the TABLE_PRACTICE
        long result = db.insert(TABLE_PRACTICE, null, values);
        // Close the database connection
        db.close();
        Log.d("SQL Insert","" + result);
        return result;
    }

    public ArrayList<Practice> getAllPractices() {
        ArrayList<Practice> practiceslist = new ArrayList<Practice>();
        String selectQuery = "SELECT " + COLUMN_ID + ","
                + COLUMN_DESCRIPTION + ","
                + COLUMN_STARS + " FROM " + TABLE_PRACTICE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String description = cursor.getString(1);
                int stars = cursor.getInt(2);

                Practice newPractice = new Practice(id, description, stars);
                practiceslist.add(newPractice);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return practiceslist;
    }

    public int updatePractice(Practice data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DESCRIPTION, data.getDescription());
        values.put(COLUMN_STARS, data.getStars());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_PRACTICE, values, condition, args);
        db.close();
        return result;
    }

    public int deletePractice(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_PRACTICE, condition, args);
        db.close();
        return result;
    }

}
