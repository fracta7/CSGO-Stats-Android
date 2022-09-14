package com.fracta7.csgostats.data.local.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM userinfo")
    suspend fun getAll(): List<UserInfoEntity>

    @Insert
    suspend fun insertAll(vararg userInfoEntity: UserInfoEntity)

    @Query("DELETE FROM userinfo")
    suspend fun deleteTable()
}