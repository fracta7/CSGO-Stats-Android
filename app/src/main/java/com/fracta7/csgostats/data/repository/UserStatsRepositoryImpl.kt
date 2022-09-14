package com.fracta7.csgostats.data.repository

import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.local.user.UserStatsEntity
import com.fracta7.csgostats.data.mapper.toUserStats
import com.fracta7.csgostats.data.mapper.toUserStatsEntity
import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserStatsRepositoryImpl @Inject constructor(db: AppDatabase) :
    UserStatsRepository {
    private val dao = db.userStatsDao()

    override suspend fun deleteAll() {
        dao.deleteTable()
    }

    override suspend fun clearMatches() {
        dao.deleteTable()
    }

    override suspend fun insert(stat: UserStats) {
        dao.insertAll(stat.toUserStatsEntity())
    }

    override suspend fun getUserStats(): Flow<Resource<List<UserStats>>> {
        return flow {
            val userStats = dao.getAll()
            if (userStats.isEmpty()) emit(Resource.Error("Repository is empty")) else emit(
                Resource.Success(
                    data = userStats.map { it.toUserStats() })
            )
        }
    }
}