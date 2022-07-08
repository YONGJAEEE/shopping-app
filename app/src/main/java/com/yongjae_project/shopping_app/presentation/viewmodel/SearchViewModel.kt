package com.yongjae_project.shopping_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjae_project.shopping_app.data.local.AppDatabase
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.repository.SearchHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchHistoryRepository) : ViewModel() {
    private val _searchHistories = MutableStateFlow<List<SearchHistoryItem>>(emptyList())
    val searchHistories = _searchHistories.asStateFlow()

    init {
        lateinit var appDatabase: AppDatabase
        val newSearchHistoryItem = SearchHistoryItem(searchText = "용재눈~ 안드로이드 장인", searchAt = "2022-07-07 09:06:15")
        viewModelScope.launch {
            appDatabase.searchHistoryDao().insertSearchHistoryItem(newSearchHistoryItem)
        }
        searchHistories.addAll(repository.getSearchHistory())
    }
}