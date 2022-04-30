package com.example.schoolisfun.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    //Find all with same email
    @Query("SELECT * FROM Child WHERE email LIKE :search")
    public List<ChildData> findUserWithEmail(String search);

    //Find all with same email and same password
//    @Query("SELECT * FROM Child WHERE email LIKE :searchEmail AND password LIKE :searchPassword")
//    public List<ChildData> findUserWithEmailAndPassword(String searchEmail, String searchPassword);

    //Get all data query
    @Query("SELECT * FROM Child")
    List<ChildData> getAll();
}