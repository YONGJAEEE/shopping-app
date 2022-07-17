package com.yongjae_project.shopping_app.presentation.di

import com.yongjae_project.shopping_app.data.datasource.SearchHistoryLocalDataSource
import com.yongjae_project.shopping_app.data.datasource.SearchHistoryLocalDataSourceImpl
import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSource
import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSourceImpl
import com.yongjae_project.shopping_app.data.local.dao.SearchHistoryDAO
import com.yongjae_project.shopping_app.data.remote.ShoppingAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun provideSearchHistoryLocalDataSource(
        dao: SearchHistoryDAO
    ): SearchHistoryLocalDataSource = SearchHistoryLocalDataSourceImpl(dao)

    @Singleton
    @Provides
    fun provideSearchShoppingListDataSource(
        service: ShoppingAPIService
    ): SearchShoppingListRemoteDataSource = SearchShoppingListRemoteDataSourceImpl(service)
}