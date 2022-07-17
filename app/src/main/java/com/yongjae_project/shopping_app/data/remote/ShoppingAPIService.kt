package com.yongjae_project.shopping_app.data.remote

import com.yongjae_project.shopping_app.BuildConfig
import com.yongjae_project.shopping_app.data.model.ShoppingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ShoppingAPIService {

   @GET("/v1/search/shop")
   @Headers(
      "X-Naver-Client-Id: ${BuildConfig.NAVER_API_ID}",
      "X-Naver-Client-Secret: ${BuildConfig.NAVER_API_SECRET}"
   )
   suspend fun getShoppingList(
      @Query(
         "query",
         encoded = true
      ) query: String
   ): Response<ShoppingResponse>
}