package com.yongjae_project.shopping_app.data.datasource

import com.yongjae_project.shopping_app.data.local.dao.SearchHistoryDAO
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

class SearchHistoryLocalDataSourceImpl(private val searchHistoryDAO: SearchHistoryDAO) :
    SearchHistoryLocalDataSource {

    override suspend fun insertSearchHistoryItem(searchHistoryItem: SearchHistoryItem) {
        searchHistoryDAO.insertSearchHistoryItem(searchHistoryItem)
    }

    override suspend fun deleteSearchHistoryItem(searchHistoryItem: SearchHistoryItem) {
        searchHistoryDAO.deleteSearchHistoryItem(searchHistoryItem)
    }

    override fun getSearchHistory(): Flow<List<SearchHistoryItem>> {
        return searchHistoryDAO.getSearchHistory()
    }

}