package com.fracta7.csgostats.data.repository

import com.fracta7.csgostats.data.csv.CSVParser
import com.fracta7.csgostats.data.local.AppDatabase
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
class SteamStatsRepositoryImpl @Inject constructor(
    val api: SteamStatApi,
    val db: AppDatabase,
    val steamStatsParser: CSVParser<SteamStats>
) : SteamStatsRepository {

    private val dao = db.steamStatsDao()

    override suspend fun getSteamStats(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<SteamStats>>> {
        return flow {
            emit(Resource.Loading(true))
            val localSteamStats = dao.getAll()
            emit(Resource.Success(
                data = localSteamStats.map { it.toSteamStats() }
            ))

            val isDbEmpty = localSteamStats.isEmpty()
            val shouldLoadFromCache = !isDbEmpty && !fetchFromRemote
            if (shouldLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }

            val remoteStats = try {
                val response = api.getSteamStats()

            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data! IO Error"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data! HTTP Error"))
                null
            }

            remoteStats?.let { stats ->
                emit(Resource.Loading(false))
            }
        }
    }
}