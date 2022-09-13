package com.fracta7.csgostats.data.repository

import androidx.annotation.WorkerThread
import com.fracta7.csgostats.data.local.steam.SteamStatsDao
import com.fracta7.csgostats.data.local.steam.SteamStatsEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
class SteamStatsRepository(
    private val steamStatsDao: SteamStatsDao
) {
    val allStats: Flow<List<SteamStatsEntity>> = steamStatsDao.getAll()

    @WorkerThread
    suspend fun insert(stat: SteamStatsEntity){
        steamStatsDao.insertAll(stat)
    }
}