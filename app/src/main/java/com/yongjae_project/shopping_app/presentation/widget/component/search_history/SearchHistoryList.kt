package com.yongjae_project.shopping_app.presentation.widget.component.search_history

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.view.search.SearchViewModel
import com.yongjae_project.shopping_app.util.Pages


@Composable
fun SearchHistoryList(
    items: List<SearchHistoryItem>,
    searchViewModel: SearchViewModel,
    navHostController: NavHostController,
) {
    LazyColumn {
        items(count = items.size) { index ->
            val item = items[index]
            SearchHistoryItemView(
                SearchHistoryItem(
                    item.searchText, item.searchAt,
                ),
                clearButtonTapEvent = {
                    searchViewModel.deleteSearchHistory(item)
                },
                itemRowTapEvent = {
                    navHostController.navigate(Pages.PRODUCT_LIST.name)
                }
            )
        }
    }
}