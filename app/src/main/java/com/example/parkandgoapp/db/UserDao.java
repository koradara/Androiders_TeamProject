package com.example.parkandgoapp.db;


import com.example.parkandgoapp.model.User;

import java.util.List;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

/**
 * ParkAndGoApp created by test

import com.example.parkandgoapp.model.User;

import java.util.List;

/**
 * ParkAndGoApp created by nisarg

 * Student ID: 991541369
 * on 2019-11-14
 */


    @Dao
    public interface UserDao {

        @Insert
        void insert(User user);

        @Update
        void update(User user);

        @Delete
        void delete(User user);

    @Query("SELECT * FROM parkandgo_table ORDER BY email ASC")
    LiveData<List<User>> getAllUsers();


    }
