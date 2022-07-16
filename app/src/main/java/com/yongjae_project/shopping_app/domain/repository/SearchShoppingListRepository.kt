package com.yongjae_project.shopping_app.domain.repository

import com.yongjae_project.shopping_app.data.model.RemoteResult
import com.yongjae_project.shopping_app.data.model.ShoppingResponse

interface SearchShoppingListRepository {
    suspend fun getSearchShoppingList(query: String) : RemoteResult<ShoppingResponse>
}