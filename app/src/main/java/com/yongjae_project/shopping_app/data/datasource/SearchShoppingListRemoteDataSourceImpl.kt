package com.yongjae_project.shopping_app.data.datasource

import com.yongjae_project.shopping_app.data.model.ShoppingResponse
import com.yongjae_project.shopping_app.data.remote.ShoppingAPIService
import retrofit2.Response

class SearchShoppingListRemoteDataSourceImpl (
   private val service : ShoppingAPIService
) : SearchShoppingListRemoteDataSource {
   override suspend fun getShoppingList(query: String): Response<ShoppingResponse> {
      return service.getShoppingList(query)
   }
}