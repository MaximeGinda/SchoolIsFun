package com.example.schoolisfun.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ChildDao {
    //Insert query
    @Insert(onConflict = REPLACE)
    void insert(ChildData... childData);

    @Update
    void update(ChildData... ChildData);

    //Delete query
    @Delete
    void delete(ChildData childData);

    //Delete all query
    @Delete
    void reset(List<ChildData> childData);

    //Find all with same name
    @Query("SELECT * FROM Child WHERE firstName LIKE :search OR lastName  LIKE :search")
    public List<ChildData> findUserWithName(String search);

    //Find all with same name
    @Query("SELECT * FROM Child WHERE childID LIKE :id")
    public List<ChildData> findUserWithId(int id);

    //Find all with same email
    @Query("SELECT * FROM Child WHERE email LIKE :search")
    public List<ChildData> findUserWithEmail(String search);

    @Query("SELECT childID FROM Child WHERE userName LIKE :userName")
    int findIdWithUserName(String userName);

    //Find all with same email and same password
    @Query("SELECT * FROM Child WHERE email LIKE :searchEmail AND password LIKE :searchPassword")
    public List<ChildData> findUserWithEmailAndPassword(String searchEmail, String searchPassword);

    //Find all with same email and same password
    @Query("SELECT * FROM Child WHERE userName LIKE :userName AND password LIKE :searchPassword")
    public List<ChildData> findUserWithUserNameAndPassword(String userName, String searchPassword);

    //Get all data query
    @Query("SELECT * FROM Child")
    List<ChildData> getAll();

    //Get ID data query
    @Query("SELECT childID FROM Child WHERE email LIKE :searchEmail")
    int findIdWithEmail(String searchEmail);

    @Query("SELECT classes FROM Child Where childID LIKE :id")
    List<String> findClassesWithID(int id);

    @Query("SELECT premiumPlan FROM Child Where childID LIKE :id")
    boolean findPremiumWithId(int id);
}