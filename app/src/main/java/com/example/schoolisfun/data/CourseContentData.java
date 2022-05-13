package com.example.schoolisfun.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;

//Define table name
@Entity(tableName = "CourseContent")
public class CourseContentData implements Serializable {
    //Create id column
    @PrimaryKey(autoGenerate = true)
    private int courseContentID;

    //Create text column
    @ColumnInfo(name = "courseName")
    private String courseName;

    @ColumnInfo(name = "summary")
    private String summary;
    @ColumnInfo(name = "boolSummary")
    private boolean boolSummary;
    @ColumnInfo(name = "video")
    private String video;
    @ColumnInfo(name = "boolVideo")
    private boolean boolVideo;
    @ColumnInfo(name = "exercise")
    private String exercise;
    @ColumnInfo(name = "boolExercise")
    private boolean boolExercise;
    @ColumnInfo(name = "quiz")
    private ArrayList<String> quiz;
    @ColumnInfo(name = "boolQuiz")
    private boolean boolQuiz;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @ColumnInfo(name = "userID")
    private int userID;

    public int getCourseContentID() {
        return courseContentID;
    }

    public void setCourseContentID(int courseContentID) {
        this.courseContentID = courseContentID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public ArrayList<String> getQuiz() {
        return quiz;
    }

    public void setQuiz(ArrayList<String> quiz) {
        this.quiz = quiz;
    }

    public boolean isBoolSummary() {
        return boolSummary;
    }

    public void setBoolSummary(boolean boolSummary) {
        this.boolSummary = boolSummary;
    }

    public boolean isBoolVideo() {
        return boolVideo;
    }

    public void setBoolVideo(boolean boolVideo) {
        this.boolVideo = boolVideo;
    }

    public boolean isBoolExercise() {
        return boolExercise;
    }

    public void setBoolExercise(boolean boolExercise) {
        this.boolExercise = boolExercise;
    }

    public boolean isBoolQuiz() {
        return boolQuiz;
    }

    public void setBoolQuiz(boolean boolQuiz) {
        this.boolQuiz = boolQuiz;
    }
}