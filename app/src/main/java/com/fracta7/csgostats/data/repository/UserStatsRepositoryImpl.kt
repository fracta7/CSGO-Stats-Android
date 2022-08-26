package com.fracta7.csgostats.data.repository

import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.mapper.toUserStats
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserStatsRepositoryImpl @Inject constructor(
    val db: AppDatabase
): UserStatsRepository {
    private val dao = db.userStatsDao()

    override suspend fun getUserStats(): Flow<Resource<List<UserStats>>> {
        return flow {
            emit(Resource.Loading(true))
            val userStats = dao.getAll()
            emit(Resource.Success(
                data = userStats.map { it.toUserStats() }
            ))
        }
    }
}