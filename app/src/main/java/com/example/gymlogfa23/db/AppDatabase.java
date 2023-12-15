package com.example.gymlogfa23.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.gymlogfa23.GymLog;
import com.example.gymlogfa23.User;
import com.example.gymlogfa23.db.typeConverters.DateTypeConverter;

@Database(entities = {GymLog.class, User.class}, version = 2)
@TypeConverters(DateTypeConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "GYMLOG_DATABASE";
    public static final String GYMLOG_TABLE = "GYMLOG_TABLE";
    public static final String USER_TABLE = "USER_TABLE";
    public abstract GymLogDAO getGymLogDAO();

}
