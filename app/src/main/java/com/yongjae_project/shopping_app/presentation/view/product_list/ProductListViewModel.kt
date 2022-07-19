package com.yongjae_project.shopping_app.presentation.view.product_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.domain.usecase.SearchShoppingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val searchShoppingListUseCase: SearchShoppingListUseCase,
) : ViewModel() {
    private val _productList : MutableLiveData<List<ProductItem>> = MutableLiveData()
    val productList : LiveData<List<ProductItem>> = _productList
    private var _query= ""

    fun searchProductList(query: String) {
        _query = query
        viewModelScope.launch{
            _productList.postValue(searchShoppingListUseCase(_query, 1).data?.items)
        }
    }

    fun addProductList(page: Int) {
        viewModelScope.launch{
            val tempList : MutableList<ProductItem>? = _productList.value?.toMutableList()
            searchShoppingListUseCase(_query, page).data?.items?.let { tempList?.addAll(it) }
            if(tempList != null){
                _productList.postValue(tempList)
            }
        }
    }
}