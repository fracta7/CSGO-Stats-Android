package com.fracta7.csgostats.data.csv

import com.fracta7.csgostats.domain.model.SteamStats
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton

/*@Singleton
class SteamStatsParser @Inject constructor() : CSVParser<SteamStats> {
    override suspend fun parse(stream: InputStream): List<SteamStats> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            csvReader
                .readAll()
                .drop(1)
                .mapNotNull { line ->
                    val lines = line.getOrNull(2)
                    SteamStats()
                    }
                }
        }
    }
}

 */