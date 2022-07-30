package com.yongjae_project.shopping_app.di

import com.yongjae_project.shopping_app.data.datasource.SearchHistoryLocalDataSource
import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSource
import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSourceImpl
import com.yongjae_project.shopping_app.data.repository.SearchHistoryRepositoryImpl
import com.yongjae_project.shopping_app.data.repository.SearchShoppingListRepositoryImpl
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository
import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository
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

    @Singleton
    @Provides
    fun provideSearchShoppingListRepository(
        dataSource: SearchShoppingListRemoteDataSource
    ): SearchShoppingListRepository = SearchShoppingListRepositoryImpl(dataSource)
}