package com.yongjae_project.shopping_app.domain.repository

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem

interface SearchHistoryRepository {

    fun getSearchHistory(): List<SearchHistoryItem>

    fun addSearchHistory(searchHistoryItem: SearchHistoryItem)

}