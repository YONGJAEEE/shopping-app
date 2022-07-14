package com.yongjae_project.shopping_app.presentation.widget.component.search

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.view.search.SearchViewModel


@Composable
fun SearchHistoryList(items: List<SearchHistoryItem>, searchViewModel: SearchViewModel) {
    LazyColumn {
        items(count = items.size) { index ->
            val item = items[index]
            SearchHistoryItemView(
                SearchHistoryItem(
                    item.searchText, item.searchAt,
                ),
                clearButtonTapEvent = {
                    searchViewModel.deleteSearchHistory(item)
                }
            )
        }
    }
}