package com.fracta7.csgostats.di

import android.app.Application
import androidx.compose.ui.platform.LocalContext
import androidx.room.Room
import com.fracta7.csgostats.data.local.AppDatabase
import com.fracta7.csgostats.data.remote.SteamStatApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDb(app: Application): AppDatabase{
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java, "app-database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideRetrofitApi(): SteamStatApi{
        return Retrofit.Builder()
            .baseUrl(SteamStatApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SteamStatApi::class.java)
    }
}