package com.fracta7.csgostats.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserStatsDao {
    @Query("SELECT * FROM userstats")
    fun getAll(): List<UserStatsEntity>

    @Insert
    fun insertAll(vararg userStats: UserStatsEntity)

    @Delete
    fun delete(stat: UserStatsEntity)

    @Query("DELETE FROM userstats")
    fun deleteTable()
}