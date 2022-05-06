package com.example.schoolisfun.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CourseContentDao {
    //Insert query
    @Insert(onConflict = REPLACE)
    void insert(CourseContentData... CourseContentData);



    //Get ID data query
    @Query("SELECT courseContentID FROM CourseContent WHERE courseName LIKE :courseName")
    int findIdWithCourseName(String courseName);

    @Query("SELECT summary FROM CourseContent Where courseContentID LIKE :id")
    String findSummaryWithID(int id);

    @Query("SELECT quiz FROM CourseContent Where courseContentID LIKE :id")
    List<String> findQuizWithID(int id);

    //Delete all query
    @Delete
    void reset(List<CourseContentData> courseContentData);
}
