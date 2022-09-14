package com.fracta7.csgostats.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fracta7.csgostats.data.local.steam.RemoteStatsDao
import com.fracta7.csgostats.data.local.steam.SteamStatsDao
import com.fracta7.csgostats.data.local.steam.SteamStatsEntity
import com.fracta7.csgostats.data.local.user.UserInfoDao
import com.fracta7.csgostats.data.local.user.UserInfoEntity
import com.fracta7.csgostats.data.local.user.UserStatsDao
import com.fracta7.csgostats.data.local.user.UserStatsEntity
import com.fracta7.csgostats.data.remote.dto.StatsDto

@Database(
    entities = [SteamStatsEntity::class, UserStatsEntity::class, StatsDto::class, UserInfoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun steamStatsDao(): SteamStatsDao
    abstract fun userStatsDao(): UserStatsDao
    abstract fun remoteStatsDao(): RemoteStatsDao
    abstract fun userInfo(): UserInfoDao
}