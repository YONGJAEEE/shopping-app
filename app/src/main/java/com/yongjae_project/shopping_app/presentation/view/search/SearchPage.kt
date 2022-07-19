package com.yongjae_project.shopping_app.presentation.view.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.widget.component.search.*


@ExperimentalComposeUiApi
@Composable
fun SearchPage(navController: NavHostController, searchViewModel: SearchViewModel) {
    val items: List<SearchHistoryItem> by searchViewModel.searchHistories.observeAsState(listOf())
    Scaffold {
        Column {
            SearchTextField(navController, searchViewModel)
            SearchHistoryList(items, searchViewModel, navController)
        }
    }
}