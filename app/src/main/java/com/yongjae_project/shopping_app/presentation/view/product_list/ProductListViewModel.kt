package com.yongjae_project.shopping_app.presentation.view.product_list

import androidx.lifecycle.*
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.data.model.RemoteResult
import com.yongjae_project.shopping_app.domain.usecase.SearchShoppingListUseCase
import com.yongjae_project.shopping_app.util.SHOPPING_API_DISPLAY_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val searchShoppingListUseCase: SearchShoppingListUseCase,
) : ViewModel() {
    private val _productResult: MutableLiveData<RemoteResult<List<ProductItem>>> = MutableLiveData()
    val productResult: LiveData<RemoteResult<List<ProductItem>>> = _productResult
    private var _query = ""

    fun searchProductList(query: String) {
        _query = query
        viewModelScope.launch {
            when (val result = searchShoppingListUseCase(_query, 1)) {
                is RemoteResult.Success -> {
                    if (result.data?.items != null) {
                        _productResult.postValue(RemoteResult.Success(result.data.items))
                    }
                }
                is RemoteResult.Error -> {
                    _productResult.postValue(
                        RemoteResult.Error(
                            result.message ?: "Unknown Error occurred"
                        )
                    )
                }
            }
        }
    }

    fun searchProductList() {
        viewModelScope.launch {
            val tempList: MutableList<ProductItem>? = _productResult.value?.data?.toMutableList()
            when (val result = searchShoppingListUseCase(
                _query,
                ((tempList?.size ?: 0) / SHOPPING_API_DISPLAY_SIZE) + 1
            )) {
                is RemoteResult.Success -> {
                    if (result.data?.items != null) {
                        tempList?.addAll(result.data.items)
                        _productResult.postValue(RemoteResult.Success(tempList!!))
                    }
                }
                is RemoteResult.Error -> {
                    _productResult.postValue(
                        RemoteResult.Error(
                            result.message ?: "Unknown Error occurred"
                        )
                    )
                }
            }
        }
    }
}