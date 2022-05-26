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

    // TOUS LES BOOLEANS
    @ColumnInfo(name = "boolQM",defaultValue = "false")
    private boolean boolQM;
    @ColumnInfo(name = "boolQCS",defaultValue = "false")
    private boolean boolQCS;
    @ColumnInfo(name = "boolQP",defaultValue = "false")
    private boolean boolQP;
    @ColumnInfo(name = "boolQE",defaultValue = "false")
    private boolean boolQE;
    @ColumnInfo(name = "boolQF",defaultValue = "false")
    private boolean boolQF;
    @ColumnInfo(name = "boolSM",defaultValue = "false")
    private boolean boolSM;
    @ColumnInfo(name = "boolSCS",defaultValue = "false")
    private boolean boolSCS;
    @ColumnInfo(name = "boolSP",defaultValue = "false")
    private boolean boolSP;
    @ColumnInfo(name = "boolSE",defaultValue = "false")
    private boolean boolSE;
    @ColumnInfo(name = "boolSF",defaultValue = "false")
    private boolean boolSF;
    @ColumnInfo(name = "boolVM",defaultValue = "false")
    private boolean boolVM;
    @ColumnInfo(name = "boolVCS",defaultValue = "false")
    private boolean boolVCS;
    @ColumnInfo(name = "boolVP",defaultValue = "false")
    private boolean boolVP;
    @ColumnInfo(name = "boolVE",defaultValue = "false")
    private boolean boolVE;
    @ColumnInfo(name = "boolVF",defaultValue = "false")
    private boolean boolVF;


    public boolean isBoolQM() {
        return boolQM;
    }

    public void setBoolQM(boolean boolQM) {
        this.boolQM = boolQM;
    }

    public boolean isBoolQCS() {
        return boolQCS;
    }

    public void setBoolQCS(boolean boolQCS) {
        this.boolQCS = boolQCS;
    }

    public boolean isBoolQP() {
        return boolQP;
    }

    public void setBoolQP(boolean boolQP) {
        this.boolQP = boolQP;
    }

    public boolean isBoolQE() {
        return boolQE;
    }

    public void setBoolQE(boolean boolQE) {
        this.boolQE = boolQE;
    }

    public boolean isBoolQF() {
        return boolQF;
    }

    public void setBoolQF(boolean boolQF) {
        this.boolQF = boolQF;
    }

    public boolean isBoolSM() {
        return boolSM;
    }

    public void setBoolSM(boolean boolSM) {
        this.boolSM = boolSM;
    }

    public boolean isBoolSCS() {
        return boolSCS;
    }

    public void setBoolSCS(boolean boolSCS) {
        this.boolSCS = boolSCS;
    }

    public boolean isBoolSP() {
        return boolSP;
    }

    public void setBoolSP(boolean boolSP) {
        this.boolSP = boolSP;
    }

    public boolean isBoolSE() {
        return boolSE;
    }

    public void setBoolSE(boolean boolSE) {
        this.boolSE = boolSE;
    }

    public boolean isBoolSF() {
        return boolSF;
    }

    public void setBoolSF(boolean boolSF) {
        this.boolSF = boolSF;
    }

    public boolean isBoolVM() {
        return boolVM;
    }

    public void setBoolVM(boolean boolVM) {
        this.boolVM = boolVM;
    }

    public boolean isBoolVCS() {
        return boolVCS;
    }

    public void setBoolVCS(boolean boolVCS) {
        this.boolVCS = boolVCS;
    }

    public boolean isBoolVP() {
        return boolVP;
    }

    public void setBoolVP(boolean boolVP) {
        this.boolVP = boolVP;
    }

    public boolean isBoolVE() {
        return boolVE;
    }

    public void setBoolVE(boolean boolVE) {
        this.boolVE = boolVE;
    }

    public boolean isBoolVF() {
        return boolVF;
    }

    public void setBoolVF(boolean boolVF) {
        this.boolVF = boolVF;
    }


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
