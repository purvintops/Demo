package com.purvin.demoapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.purvin.demoapplication.models.ActivitiesInfo;

/**
 * Created by Tops on 6/2/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "shopsInfo";
    // Contacts table name
    private static final String TABLE_ACTIVITIES = "activities";
    // ACTIVITIES Table Columns names
    private static final String KEY_ACTIVITIES_ID = "id";
    private static final String KEY_ACTIVITIES_CATEGORY_ID  = "category_id";
    private static final String KEY_ACTIVITIES_TITLE        = "activity_title";
    private static final String KEY_ACTIVITIES_DESC         = "activity_desc";
    private static final String KEY_ACTIVITIES_PHOTO        = "photo";
    private static final String KEY_ACTIVITIES_TIME         = "activity_time";
    private static final String KEY_ACTIVITIES_VENUE        = "venue";
    private static final String KEY_ACTIVITIES_TRAINER      = "trainer";
    private static final String KEY_ACTIVITIES_CRDATE       = "crdate";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ACTIVITIES_TABLE = "CREATE TABLE " + TABLE_ACTIVITIES + "("
                + KEY_ACTIVITIES_ID + " INTEGER PRIMARY KEY," + KEY_ACTIVITIES_TITLE + " TEXT,"
                + KEY_ACTIVITIES_DESC + " TEXT" + ")";
        db.execSQL(CREATE_ACTIVITIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACTIVITIES);
        // Creating tables again
        onCreate(db);
    }

    // Adding new Activities
    public void addActivities(ActivitiesInfo activityInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ACTIVITIES_TITLE, activityInfo.getActivityTitle()); // Activities title
        values.put(KEY_ACTIVITIES_DESC, activityInfo.getActivityDesc()); // Activities desc
        // Inserting Row
        db.insert(TABLE_ACTIVITIES, null, values);
        db.close(); // Closing database connection
    }
}
