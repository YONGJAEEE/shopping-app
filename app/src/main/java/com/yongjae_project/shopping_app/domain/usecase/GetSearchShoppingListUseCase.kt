package com.yongjae_project.shopping_app.domain.usecase

import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository

class GetSearchShoppingListUseCase(private val repository: SearchShoppingListRepository) {
   fun invoke() = repository.getSearchShoppingList()
}