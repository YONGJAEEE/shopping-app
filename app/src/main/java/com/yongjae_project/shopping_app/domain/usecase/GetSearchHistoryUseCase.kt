package com.yongjae_project.shopping_app.domain.usecase

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository

class GetSearchHistoryUseCase(private val searchHistoryRepository: SearchHistoryRepository) {
    operator fun invoke(): List<SearchHistoryItem> {
        return searchHistoryRepository.getSearchHistory()
    }
}