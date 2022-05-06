package com.example.schoolisfun.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

//Add database entities

@Database(entities = {ChildData.class, ParentData.class, CourseContentData.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class RoomDB extends RoomDatabase {
    //Create database instance
    private static RoomDB database;

    //Define database name
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance(Context context) {
        //Check condition
        if (database == null) {
            //When database is null, Initialize database
            database = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        //Return database
        return database;
    }

    //Create DAO
    public abstract ChildDao childDao();

    //    public abstract ParentDao parentDao();

//    public abstract CourseContentDao courseContentDao();
}
