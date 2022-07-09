package com.yongjae_project.shopping_app.presentation.view.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.component.BackIcon
import com.yongjae_project.shopping_app.presentation.component.SearchIcon
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor
import com.yongjae_project.shopping_app.presentation.ui.theme.Shopping_appTheme
import com.yongjae_project.shopping_app.presentation.view.search.widget.SearchHistoryItemView
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalComposeUiApi
@AndroidEntryPoint
class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Shopping_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val searchViewModel: SearchViewModel by viewModels()
                    SearchPage(searchViewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchPage(searchViewModel: SearchViewModel = viewModel()) {
    Scaffold {
        Column {
            SearchTextField(searchViewModel)
            LazyColumn() {
                items(count = searchViewModel.searchHistories.value?.size ?: 0){ index ->
                    val item = searchViewModel.searchHistories.value!![index]
                    SearchHistoryItemView(
                        SearchHistoryItem(
                            item.searchText, item.searchAt
                        )
                    )
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun SearchTextField(searchViewModel: SearchViewModel = viewModel()) {
    val textState: MutableState<String> = remember { mutableStateOf("") }
    Column {
        TextField(
            value = textState.value,
            placeholder = { Text("검색어를 입력해주세요.") },
            onValueChange = { textState.value = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 4.dp),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = {BackIcon()},
            trailingIcon = { SearchIcon() },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
        Divider(color= MainColor)
    }
}