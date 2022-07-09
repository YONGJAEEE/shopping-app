package com.yongjae_project.shopping_app.presentation.di

import android.content.Context
import androidx.room.Room
import com.yongjae_project.shopping_app.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideSearchHistoryDao(appDatabase: AppDatabase) = appDatabase.searchHistoryDao()
}