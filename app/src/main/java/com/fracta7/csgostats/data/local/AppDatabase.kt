package com.fracta7.csgostats.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fracta7.csgostats.data.local.user.UserStatsDao
import com.fracta7.csgostats.data.local.user.UserStatsEntity

@Database(
    entities = [UserStatsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userStatsDao(): UserStatsDao
}