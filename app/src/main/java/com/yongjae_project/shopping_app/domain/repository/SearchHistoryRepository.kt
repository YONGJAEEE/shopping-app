package com.yongjae_project.shopping_app.domain.repository

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface SearchHistoryRepository {

    fun getSearchHistory(): Flow<List<SearchHistoryItem>>

    suspend fun addSearchHistory(searchHistoryItem: SearchHistoryItem)

    suspend fun deleteSearchHistory(searchHistoryItem: SearchHistoryItem)

}