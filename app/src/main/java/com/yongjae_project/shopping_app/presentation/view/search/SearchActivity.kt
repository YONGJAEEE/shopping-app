package com.yongjae_project.shopping_app.presentation.view.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.component.BackIcon
import com.yongjae_project.shopping_app.presentation.component.SearchIcon
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor
import com.yongjae_project.shopping_app.presentation.ui.theme.Shopping_appTheme
import com.yongjae_project.shopping_app.presentation.view.search.widget.SearchHistoryItemView

class SearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Shopping_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SearchPage()
                }
            }
        }
    }
}

@Composable
fun SearchPage() {
    Scaffold {
        SearchTextField()
    }
}

@Composable
fun SearchTextField() {
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
        SearchHistoryItemView(
            SearchHistoryItem(
                "검색어", "07.05"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Shopping_appTheme {
        SearchPage()
    }
}