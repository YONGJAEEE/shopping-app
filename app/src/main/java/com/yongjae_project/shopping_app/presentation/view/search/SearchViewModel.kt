package com.yongjae_project.shopping_app.presentation.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.domain.usecase.AddSearchHistoryUseCase
import com.yongjae_project.shopping_app.domain.usecase.DeleteSearchHistoryUseCase
import com.yongjae_project.shopping_app.domain.usecase.GetSearchHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch
import java.util.*

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val addSearchHistoryUseCase: AddSearchHistoryUseCase,
    private val deleteSearchHistoryUseCase: DeleteSearchHistoryUseCase,
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
) : ViewModel() {
    private val _searchHistories : MutableLiveData<List<SearchHistoryItem>> = MutableLiveData()
    val searchHistories : LiveData<List<SearchHistoryItem>> = _searchHistories

    init {
        viewModelScope.launch {
            getSearchHistoryUseCase().collect{
                _searchHistories.postValue(it)
            }
        }
    }

    fun addSearchHistory(searchedText: String){
        viewModelScope.launch {
            val item = SearchHistoryItem(
                searchedText,
                Calendar.getInstance().time.toString(),
            )
            addSearchHistoryUseCase(item)
        }
    }

    fun deleteSearchHistory(searchedItem: SearchHistoryItem){
        viewModelScope.launch {
            deleteSearchHistoryUseCase(searchedItem)
        }
    }
}