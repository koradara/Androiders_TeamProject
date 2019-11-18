package com.example.parkandgoapp.db;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.parkandgoapp.model.User;

import java.util.List;

/**
 * ParkAndGoApp created by nisarg
 * Student ID: 991541369
 * on 2019-11-14
 */
public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDB db = UserDB.getINSTANCE(application);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }


    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public void insert(User user){
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao asyncTaskDao;

        insertAsyncTask(UserDao userDao) {
            asyncTaskDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            asyncTaskDao.insert(users[0]);
            return null;
        }
    }
}
