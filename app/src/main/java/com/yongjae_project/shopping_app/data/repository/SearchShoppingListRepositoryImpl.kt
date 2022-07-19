package com.yongjae_project.shopping_app.data.repository

import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSource
import com.yongjae_project.shopping_app.data.model.RemoteResult
import com.yongjae_project.shopping_app.data.model.ShoppingResponse
import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository

class SearchShoppingListRepositoryImpl(
   private val dataSource: SearchShoppingListRemoteDataSource
) : SearchShoppingListRepository {
   override suspend fun getSearchShoppingList(query: String, page: Int): RemoteResult<ShoppingResponse> {
      val response = dataSource.getShoppingList(query, page)
      if(response.isSuccessful){
         response.body()?.let {
              return RemoteResult.Success(data = it)
         }
      }
      return  RemoteResult.Error(response.message())
   }
}