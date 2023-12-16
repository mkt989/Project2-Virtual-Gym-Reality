package com.example.gymlogfa23.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gymlogfa23.GymLog;
import com.example.gymlogfa23.User;

import java.util.List;

@Dao
public interface GymLogDAO {

    @Insert
    void insert(GymLog... gymLogs); //...can take one or more arguments

    @Update
    void update(GymLog... gymLogs);

    @Delete
    void delete(GymLog gymLog);

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " ORDER BY mDate DESC")
    List<GymLog> getAllGymLogs();          //this is the return value

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE mLogId = :logId")
    List<GymLog> getGymLogsById(int logId);

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE mUserId = :userId ORDER BY mDate DESC")
    List<GymLog> getGymLogsByUserId(int userId);

    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUsername =:username")
    User getUserByUsername(String username);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId =:userId")
    User getUserByUserId(int userId);
}
