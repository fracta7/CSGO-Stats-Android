package com.fracta7.csgostats.data.local

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SteamStatsEntity::class, UserStatsEntity::class],
    version = 1,

)
abstract class AppDatabase : RoomDatabase() {
    abstract fun steamStatsDao(): SteamStatsDao
    abstract fun userStatsDao(): UserStatsDao
}