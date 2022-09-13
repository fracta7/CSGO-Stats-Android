package com.fracta7.csgostats.data.local.steam

import androidx.room.*
import com.fracta7.csgostats.data.remote.dto.StatsDto

@Dao
interface RemoteStatsDao {
    @Query("SELECT * FROM remotestats")
    suspend fun getAll(): List<StatsDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg remoteStats: StatsDto)

    @Delete
    suspend fun delete(stat: StatsDto)

    @Query("DELETE FROM remotestats")
    suspend fun deleteTable()
}