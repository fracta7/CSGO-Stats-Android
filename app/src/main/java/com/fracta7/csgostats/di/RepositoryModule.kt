package com.fracta7.csgostats.di

import com.fracta7.csgostats.data.repository.UserStatsRepositoryImpl
import com.fracta7.csgostats.domain.repository.UserStatsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun repositoryBinder(userStatsRepositoryImpl: UserStatsRepositoryImpl): UserStatsRepository

}