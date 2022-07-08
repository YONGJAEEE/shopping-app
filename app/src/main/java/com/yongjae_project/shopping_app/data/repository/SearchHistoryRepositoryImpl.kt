package com.yongjae_project.shopping_app.data.repository

import com.yongjae_project.shopping_app.data.datasource.SearchHistoryLocalDataSource
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.Flow

class SearchHistoryRepositoryImpl(
    private val searchHistoryLocalDataSource: SearchHistoryLocalDataSource
) : SearchHistoryRepository {

    override fun getSearchHistory(): Flow<List<SearchHistoryItem>> {
        return searchHistoryLocalDataSource.getSearchHistory()
    }

    override suspend fun addSearchHistory(searchHistoryItem: SearchHistoryItem) {
        return searchHistoryLocalDataSource.insertSearchHistoryItem(searchHistoryItem)
    }

    override suspend fun deleteSearchHistory(searchHistoryItem: SearchHistoryItem) {
        return searchHistoryLocalDataSource.deleteSearchHistoryItem(searchHistoryItem)
    }

}