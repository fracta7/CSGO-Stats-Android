package com.fracta7.csgostats.data.local

import androidx.room.*
import com.fracta7.csgostats.domain.model.Stats
import kotlinx.coroutines.flow.Flow

@Dao
interface RemoteStatsDao {
    @Query("SELECT * FROM remotestats")
    suspend fun getAll(): List<Stats>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg remoteStats: Stats)

    @Delete
    suspend fun delete(stat: Stats)

    @Query("DELETE FROM remotestats")
    suspend fun deleteTable()
}