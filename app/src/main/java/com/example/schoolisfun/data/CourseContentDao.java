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

    @Query("SELECT summary FROM CourseContent Where userID LIKE :id AND courseName LIKE :classname")
    String findSummaryWithID(int id, String classname);

    @Query("SELECT boolQuiz FROM CourseContent Where userID LIKE :id AND courseName LIKE :classname")
    Boolean findboolQuizWithID(int id, String classname);

    @Query("SELECT quiz FROM CourseContent Where courseName LIKE :classname")
    List<String> findQuizWithClassname(String classname);

    @Query("SELECT boolExercise FROM CourseContent Where userID LIKE :id AND courseName LIKE :classname")
    Boolean findboolExerciseWithID(int id, String classname);

    @Query("SELECT boolVideo FROM CourseContent Where userID LIKE :id AND courseName LIKE :classname")
    Boolean findboolVideoWithID(int id, String classname);

    @Query("SELECT boolSummary FROM CourseContent Where userID LIKE :id AND courseName LIKE :classname")
    Boolean findboolSummaryWithID(int id, String classname);

    @Query("SELECT quiz FROM CourseContent Where courseContentID LIKE :id")
    List<String> findQuizWithID(int id);

    @Query("UPDATE CourseContent SET boolQuiz = :boolQuiz Where userID LIKE :id AND courseName LIKE :courseName")
    void updateBoolQuiz(boolean boolQuiz, int id, String courseName);

    @Query("UPDATE CourseContent SET boolSummary = :boolSummary Where userID LIKE :id AND courseName LIKE :courseName")
    void updateBoolSummary(boolean boolSummary, int id, String courseName);

    //Delete all query
    @Delete
    void reset(List<CourseContentData> courseContentData);
}
