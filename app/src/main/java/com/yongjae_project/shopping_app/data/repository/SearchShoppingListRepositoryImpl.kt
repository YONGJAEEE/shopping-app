package com.yongjae_project.shopping_app.data.repository

import com.yongjae_project.shopping_app.data.datasource.SearchShoppingListRemoteDataSource
import com.yongjae_project.shopping_app.data.model.RemoteResult
import com.yongjae_project.shopping_app.data.model.ShoppingResponse
import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository

class SearchShoppingListRepositoryImpl(
   private val dataSource: SearchShoppingListRemoteDataSource
) : SearchShoppingListRepository {
   override suspend fun getSearchShoppingList(query: String): RemoteResult<ShoppingResponse> {
      val response = dataSource.getShoppingList(query)
      return if(response.isSuccessful){
         var res: ShoppingResponse
         response.body()?.let {
            res = it
         }
         return RemoteResult.Success(data = res)
      }else {
         return RemoteResult.Error(response.message())
      }
   }
}