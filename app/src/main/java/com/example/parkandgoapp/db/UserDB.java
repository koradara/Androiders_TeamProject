package com.example.parkandgoapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.parkandgoapp.model.User;

/**
 * ParkAndGoApp created by nisarg
 * Student ID: 991541369
 * on 2019-11-14
 */
@Database(entities = {User.class}, version = 1)

public abstract class UserDB extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile UserDB INSTANCE;

    public static UserDB getINSTANCE(final Context context) {
        if (INSTANCE == null){
            synchronized (UserDB.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        UserDB.class, "park_and_go_app_database").build();
            }
        }
        return INSTANCE;
    }
}
