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
    @ColumnInfo(name = "video")
    private String video;

    @ColumnInfo(name = "quiz")
    private ArrayList<String> quiz;


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

    public ArrayList<String> getQuiz() {
        return quiz;
    }

    public void setQuiz(ArrayList<String> quiz) {
        this.quiz = quiz;
    }


}