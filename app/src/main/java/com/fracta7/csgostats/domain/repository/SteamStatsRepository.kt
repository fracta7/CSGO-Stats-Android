package com.fracta7.csgostats.domain.repository

import com.fracta7.csgostats.domain.model.SteamStats
import com.fracta7.csgostats.util.Resource
import kotlinx.coroutines.flow.Flow

interface SteamStatsRepository {
    suspend fun getSteamStats(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<SteamStats>>>
}