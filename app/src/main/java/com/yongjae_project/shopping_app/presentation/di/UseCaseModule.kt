package com.yongjae_project.shopping_app.presentation.di

import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository
import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository
import com.yongjae_project.shopping_app.domain.usecase.AddSearchHistoryUseCase
import com.yongjae_project.shopping_app.domain.usecase.DeleteSearchHistoryUseCase
import com.yongjae_project.shopping_app.domain.usecase.GetSearchHistoryUseCase
import com.yongjae_project.shopping_app.domain.usecase.SearchShoppingListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideAddSearchHistoryUseCase(
        repository: SearchHistoryRepository
    ) = AddSearchHistoryUseCase(repository)

    @Singleton
    @Provides
    fun provideDeleteSearchHistoryUseCase(
        repository: SearchHistoryRepository
    ) = DeleteSearchHistoryUseCase(repository)

    @Singleton
    @Provides
    fun provideGetSearchHistoryUseCase(
        repository: SearchHistoryRepository
    ) = GetSearchHistoryUseCase(repository)

    @Singleton
    @Provides
    fun provideSearchShoppingListUseCase(
        repository: SearchShoppingListRepository
    ) = SearchShoppingListUseCase(repository)
}