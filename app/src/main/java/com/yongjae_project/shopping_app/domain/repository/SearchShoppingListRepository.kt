package com.yongjae_project.shopping_app.domain.repository

import com.yongjae_project.shopping_app.data.model.SearchedShoppingItem
import kotlinx.coroutines.flow.Flow

interface SearchShoppingListRepository {
    fun getSearchShoppingList() : Flow<Result<List<SearchedShoppingItem>>>
}