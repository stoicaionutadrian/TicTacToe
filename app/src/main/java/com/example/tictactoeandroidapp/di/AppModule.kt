package com.example.tictactoeandroidapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

//    @Provides
//    @Singleton
//    fun providesHistoryRepository(): HistoryRepository {
//        return HistoryRepositoryImpl(
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun providesProgressRepository(): ProgressRepository {
//        return ProgressRepositoryImpl()
//    }
}