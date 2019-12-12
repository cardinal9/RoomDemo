package com.example.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.room.Dao.UserDao;
import com.example.room.Model.User;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserRoomDatabase database = UserRoomDatabase.getDatabas(application);
        userDao = database.userDao();
        allUsers = userDao.getUsers();
    }

    public void insert(User user) {
        UserRoomDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insert(user);
        });
    }

    public LiveData<List<User>> getAllWords() {
        return allUsers;
    }
}
