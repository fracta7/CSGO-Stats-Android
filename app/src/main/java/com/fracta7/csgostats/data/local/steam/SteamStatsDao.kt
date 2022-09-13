package com.fracta7.csgostats.data.local.steam

import androidx.room.*
import com.fracta7.csgostats.data.local.steam.SteamStatsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SteamStatsDao {
    @Query("SELECT * FROM steamstats")
    fun getAll(): Flow<List<SteamStatsEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg steamStats: SteamStatsEntity)

    @Delete
    suspend fun delete(stat: SteamStatsEntity)

    @Query("DELETE FROM steamstats")
    suspend fun deleteTable()
}