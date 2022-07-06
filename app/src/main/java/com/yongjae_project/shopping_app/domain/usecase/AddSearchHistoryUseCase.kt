package com.yongjae_project.shopping_app.domain.usecase

import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository

class AddSearchHistoryUseCase(private val repository: SearchHistoryRepository) {
    operator fun invoke(searchHistoryItem: SearchHistoryItem){
        repository.addSearchHistory(searchHistoryItem)
    }
}