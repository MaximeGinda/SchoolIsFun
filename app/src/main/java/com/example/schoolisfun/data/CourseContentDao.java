package com.example.schoolisfun.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CourseContentDao {

    //Insert query
    @Insert(onConflict = REPLACE)
    void insert(CourseContentData... CourseContentData);

    //Get ID data query
    @Query("SELECT courseContentID FROM CourseContent WHERE courseName LIKE :courseName")
    int findIdWithCourseName(String courseName);

    //Get all data query
    @Query("SELECT * FROM CourseContent")
    List<CourseContentData> getAll();

    @Query("SELECT summary FROM CourseContent Where  courseName LIKE :classname")
    String findSummaryWithID(String classname);


    @Query("SELECT quiz FROM CourseContent Where courseName LIKE :classname")
    List<String> findQuizWithClassname(String classname);

    @Query("SELECT quiz FROM CourseContent Where courseContentID LIKE :id")
    List<String> findQuizWithID(int id);


    //Delete all query
    @Delete
    void reset(List<CourseContentData> courseContentData);
}
