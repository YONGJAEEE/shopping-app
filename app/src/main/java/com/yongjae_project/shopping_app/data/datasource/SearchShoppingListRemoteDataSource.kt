package com.yongjae_project.shopping_app.data.datasource

import com.yongjae_project.shopping_app.data.model.ShoppingResponse
import retrofit2.Response

interface SearchShoppingListRemoteDataSource {
   suspend fun getShoppingList(query : String, page: Int) : Response<ShoppingResponse>
}