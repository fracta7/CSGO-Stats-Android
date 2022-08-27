package com.fracta7.csgostats

import android.app.Application
import androidx.room.Room
import com.fracta7.csgostats.data.local.AppDatabase

class StatsApplication(var db: AppDatabase?): Application() {
    fun getDbInstance(): AppDatabase{

        return db as AppDatabase
    }
}