package com.yongjae_project.shopping_app.domain.usecase

import com.yongjae_project.shopping_app.domain.repository.SearchShoppingListRepository

class SearchShoppingListUseCase(private val repository: SearchShoppingListRepository) {
   suspend operator fun invoke(query: String) = repository.getSearchShoppingList(query)
}