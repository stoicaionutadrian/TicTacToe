package com.example.tictactoeandroidapp.di

import com.example.tictactoeandroidapp.data.GameRepository
import com.example.tictactoeandroidapp.data.GameRepositoryImpl
import com.example.tictactoeandroidapp.data.SystemInfoRepository
import com.example.tictactoeandroidapp.data.SystemInfoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun providesGameService(): GameRepository {
        return GameRepositoryImpl()
    }

    @Provides
    @Singleton
    fun providesSystemInfoService(): SystemInfoRepository {
        return SystemInfoRepositoryImpl()
    }
}