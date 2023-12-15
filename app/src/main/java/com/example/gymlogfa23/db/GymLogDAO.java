package com.example.gymlogfa23.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gymlogfa23.GymLog;

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
    List<GymLog> getGymLogs();          //this is the return value

    @Query("SELECT * FROM " + AppDatabase.GYMLOG_TABLE + " WHERE mLogId = :logId")
    GymLog getGymLogsById(int logId);

}
