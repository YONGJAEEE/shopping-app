package com.yongjae_project.shopping_app.data.repository

import com.yongjae_project.shopping_app.data.datasource.SearchHistoryDataSource
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository

class SearchHistoryRepositoryImpl (
    private val localDataSource: SearchHistoryDataSource
) : SearchHistoryRepository {
    override fun getSearchHistory(): List<SearchHistoryItem> {
        return localDataSource.getSearchHistory()
    }

    override fun addSearchHistory(item: SearchHistoryItem) {
        localDataSource.addSearchHistoryItem(item)
    }

}