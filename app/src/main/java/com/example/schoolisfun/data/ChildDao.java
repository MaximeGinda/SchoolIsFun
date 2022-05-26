package com.example.schoolisfun.data;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;
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

    @Query("SELECT boolQM FROM child Where childID LIKE :id")
    boolean findboolQMWithId(int id);

    @Query("SELECT boolQCS FROM child Where childID LIKE :id")
    boolean findboolQCSWithId(int id);

    @Query("SELECT boolQP FROM child Where childID LIKE :id")
    boolean findboolQPWithId(int id);

    @Query("SELECT boolQE FROM child Where childID LIKE :id")
    boolean findboolQEWithId(int id);

    @Query("SELECT boolQF FROM child Where childID LIKE :id")
    boolean findboolQFWithId(int id);

    @Query("SELECT boolSM FROM child Where childID LIKE :id")
    boolean findboolSMWithId(int id);

    @Query("SELECT boolSCS FROM child Where childID LIKE :id")
    boolean findboolSCSWithId(int id);

    @Query("SELECT boolSP FROM child Where childID LIKE :id")
    boolean findboolSPWithId(int id);

    @Query("SELECT boolSE FROM child Where childID LIKE :id")
    boolean findboolSEWithId(int id);

    @Query("SELECT boolSF FROM child Where childID LIKE :id")
    boolean findboolSFWithId(int id);

    @Query("SELECT boolVM FROM child Where childID LIKE :id")
    boolean findboolVMWithId(int id);

    @Query("SELECT boolVCS FROM child Where childID LIKE :id")
    boolean findboolVCSWithId(int id);

    @Query("SELECT boolVP FROM child Where childID LIKE :id")
    boolean findboolVPWithId(int id);

    @Query("SELECT boolVE FROM child Where childID LIKE :id")
    boolean findboolVEWithId(int id);

    @Query("SELECT boolVF FROM child Where childID LIKE :id")
    boolean findboolVFWithId(int id);

    @Query("UPDATE Child SET boolQM = :bool Where childID LIKE :id")
    void updateboolQMWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolQCS = :bool Where childID LIKE :id")
    void updateboolQCSWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolQP = :bool Where childID LIKE :id")
    void updateboolQPWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolQE = :bool Where childID LIKE :id")
    void updateboolQEWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolQF = :bool Where childID LIKE :id")
    void updateboolQFWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolSM = :bool Where childID LIKE :id")
    void updateboolSMWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolSCS = :bool Where childID LIKE :id")
    void updateboolSCSWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolSP = :bool Where childID LIKE :id")
    void updateboolSPWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolSE = :bool Where childID LIKE :id")
    void updateboolSEWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolSF = :bool Where childID LIKE :id")
    void updateboolSFWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolVM = :bool Where childID LIKE :id")
    void updateboolVMWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolVCS = :bool Where childID LIKE :id")
    void updateboolVCSWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolVP = :bool Where childID LIKE :id")
    void updateboolVPWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolVE = :bool Where childID LIKE :id")
    void updateboolVEWithId(int id, boolean bool);

    @Query("UPDATE Child SET boolVF = :bool Where childID LIKE :id")
    void updateboolVFWithId(int id, boolean bool);

}