package com.fracta7.csgostats.data.local

import androidx.room.*

@Dao
interface SteamStatsDao {
    @Query("SELECT * FROM steamstats")
    fun getAll(): List<SteamStatsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg steamStats: SteamStatsEntity)

    @Delete
    fun delete(stat: SteamStatsEntity)

    @Query("DELETE FROM steamstats")
    fun deleteTable()
}