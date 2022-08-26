package com.fracta7.csgostats.data.repository

import androidx.annotation.WorkerThread
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.SteamStatsEntity
import com.fracta7.csgostats.data.local.UserStatsDao
import com.fracta7.csgostats.data.local.UserStatsEntity
import com.fracta7.csgostats.data.mapper.toUserStats
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserStatsRepository @Inject constructor(private val userStatsDao: UserStatsDao) {
    val allStats: Flow<List<UserStatsEntity>> = userStatsDao.getAll()

    @WorkerThread
    suspend fun insert(stat: UserStatsEntity){
        userStatsDao.insertAll(stat)
    }

    @WorkerThread
    suspend fun deleteAll(){
        userStatsDao.deleteTable()
    }
}