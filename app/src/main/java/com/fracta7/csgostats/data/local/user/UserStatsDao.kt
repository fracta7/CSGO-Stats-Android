package com.fracta7.csgostats.data.local.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserStatsDao {
    @Query("SELECT * FROM userstats")
    suspend fun getAll(): List<UserStatsEntity>

    @Insert
    suspend fun insertAll(vararg userStats: UserStatsEntity)

    @Delete
    suspend fun delete(stat: UserStatsEntity)

    @Query("DELETE FROM userstats")
    suspend fun deleteTable()
}