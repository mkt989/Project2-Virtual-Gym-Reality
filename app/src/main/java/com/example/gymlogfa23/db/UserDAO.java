package com.example.gymlogfa23.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.gymlogfa23.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    void deleteUser(User user);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getAllUsers();

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = :userId")
    User getUserById(int userId);

    // Add other query methods as per your requirements
    // For example, to get a user by username:
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserName = :userName")
    User getUserByUsername(String userName);
}
