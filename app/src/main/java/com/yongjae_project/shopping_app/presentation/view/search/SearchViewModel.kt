package com.yongjae_project.shopping_app.presentation.view.search

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

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val addSearchHistoryUseCase: AddSearchHistoryUseCase,
    private val deleteSearchHistoryUseCase: DeleteSearchHistoryUseCase,
    private val getSearchHistoryUseCase: GetSearchHistoryUseCase,
) : ViewModel() {
    val searchHistories : MutableLiveData<List<SearchHistoryItem>> = MutableLiveData()

    init {
        viewModelScope.launch {
            getSearchHistoryUseCase().collect{
                searchHistories.postValue(it)
            }
        }
    }
}