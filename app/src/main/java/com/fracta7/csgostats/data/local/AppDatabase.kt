package com.fracta7.csgostats.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.fracta7.csgostats.domain.model.Stats
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [SteamStatsEntity::class, UserStatsEntity::class, Stats::class],
    version = 1,

    )
abstract class AppDatabase : RoomDatabase() {
    abstract fun steamStatsDao(): SteamStatsDao
    abstract fun userStatsDao(): UserStatsDao
    abstract fun remoteStatsDao(): RemoteStatsDao

/*    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "app-database"
                ).addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.userStatsDao())
                }
            }

        }

        suspend fun populateDatabase(statsDao: UserStatsDao) {
            // Delete all content here.
            statsDao.insertAll(UserStatsEntity(0, 0, 0, "0", 0, 0, 0, 0f, 0f, 0, "0", false))
        }
    } */
}