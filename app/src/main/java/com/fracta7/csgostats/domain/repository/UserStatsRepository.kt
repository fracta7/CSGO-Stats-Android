package com.fracta7.csgostats.domain.repository

import com.fracta7.csgostats.domain.model.UserStats
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow

interface UserStatsRepository {
    suspend fun getUserStats(
    ): Flow<Resource<List<UserStats>>>
}