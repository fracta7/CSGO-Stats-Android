package com.fracta7.csgostats.data.repository

import androidx.annotation.WorkerThread
import com.fracta7.csgostats.data.csv.CSVParser
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.SteamStatsDao
import com.fracta7.csgostats.data.local.SteamStatsEntity
import com.fracta7.csgostats.data.mapper.toSteamStats
import com.fracta7.csgostats.data.mapper.toSteamStatsEntity
import com.fracta7.csgostats.data.remote.SteamStatApi
import com.fracta7.csgostats.domain.model.SteamStats
import com.fracta7.csgostats.domain.repository.SteamStatsRepository
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
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