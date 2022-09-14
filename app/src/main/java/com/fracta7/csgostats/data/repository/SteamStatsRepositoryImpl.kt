package com.fracta7.csgostats.data.repository

import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.mapper.toUserInfo
import com.fracta7.csgostats.domain.model.SteamStats
import com.fracta7.csgostats.domain.model.UserInfo
import com.fracta7.csgostats.domain.repository.SteamStatsRepository
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SteamStatsRepositoryImpl @Inject constructor(
    private val db: AppDatabase
) : SteamStatsRepository {
    override suspend fun getSteamStats(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<SteamStats>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserInfo(): Flow<Resource<UserInfo>> {
        return flow {
            val userInfo = db.userInfo().getAll()
            if (userInfo.isEmpty()) {
                emit(Resource.Error("Database is empty"))
            } else {
                emit(Resource.Success(data = userInfo[0].toUserInfo()))
            }
        }
    }

}