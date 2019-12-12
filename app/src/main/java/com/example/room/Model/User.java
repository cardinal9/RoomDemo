package com.example.room.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table")
public class User {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user")
    public String mUser;

    public User(@NonNull String user) {
        this.mUser = user;
    }

    public String getmUser() {
        return this.mUser;
    }
}
