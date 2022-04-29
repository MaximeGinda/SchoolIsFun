package com.example.schoolisfun.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Define table name
@Entity(tableName = "Child")
public class ChildData implements Serializable {
    //Create id column
    @PrimaryKey(autoGenerate = true)
    private int childID;

    //Create text column
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private String password;
    @ColumnInfo(name = "lastName")
    private String lastName;
    @ColumnInfo(name = "firstName")
    private String firstName;
    @ColumnInfo(name = "userName")
    private String userName;
    @ColumnInfo(name = "phoneNumber")
    private String phoneNumber;
    @ColumnInfo(name = "profileImage")
    private String profileImage;
    @ColumnInfo(name = "schoolLevel")
    private String schoolLevel;
    @ColumnInfo(name = "premiumPlan")
    private boolean premiumPlan;
    @ColumnInfo(name = "classes")
    private ArrayList<String> classes;

    //Generate getter and setter
    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getSchoolLevel() {
        return schoolLevel;
    }

    public void setSchoolLevel(String schoolLevel) {
        this.schoolLevel = schoolLevel;
    }

    public boolean isPremiumPlan() {
        return premiumPlan;
    }

    public void setPremiumPlan(boolean premiumPlan) {
        this.premiumPlan = premiumPlan;
    }

    public ArrayList<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }
}
