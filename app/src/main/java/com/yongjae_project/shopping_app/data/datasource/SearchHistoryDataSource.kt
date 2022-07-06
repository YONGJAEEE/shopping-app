package com.yongjae_project.shopping_app.data.datasource

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem

interface SearchHistoryDataSource {

    fun getSearchHistory() : List<SearchHistoryItem>

    fun addSearchHistoryItem(item: SearchHistoryItem)
}