package com.example.schoolisfun.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

//Add database entities

@Database(entities = {CourseContentData.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class RoomDBcontent extends RoomDatabase {
    //Create database instance
    private static RoomDBcontent database;

    //Define database name
    private static String DATABASE_NAME = "databaseContent";

    public synchronized static RoomDBcontent getInstance(Context context) {
        //Check condition
        if (database == null) {
            //When database is null, Initialize database
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDBcontent.class, DATABASE_NAME)
                    .createFromAsset("database/CourseContent.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //Return database
        return database;
    }

    public abstract CourseContentDao courseContentDao();
}