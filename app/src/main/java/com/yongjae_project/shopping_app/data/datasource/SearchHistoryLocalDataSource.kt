package com.yongjae_project.shopping_app.data.datasource

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface SearchHistoryLocalDataSource {

    suspend fun insertSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    suspend fun deleteSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    fun getSearchHistory() : Flow<List<SearchHistoryItem>>

}