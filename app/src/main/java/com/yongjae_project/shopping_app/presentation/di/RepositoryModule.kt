package com.yongjae_project.shopping_app.presentation.di

import com.yongjae_project.shopping_app.data.datasource.SearchHistoryLocalDataSource
import com.yongjae_project.shopping_app.data.repository.SearchHistoryRepositoryImpl
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSearchHistoryRepository(
        dataSource: SearchHistoryLocalDataSource
    ): SearchHistoryRepository = SearchHistoryRepositoryImpl(dataSource)
}