package com.example.sl.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.sl.model.UserEntity;

@Dao
public interface UserDao {

    @Insert
    void registerUsers(UserEntity userEntity);

    @Query("SELECT * FROM users WHERE userId=(:userId) and password=(:password)")
    UserEntity login(String userId, String password);

}
