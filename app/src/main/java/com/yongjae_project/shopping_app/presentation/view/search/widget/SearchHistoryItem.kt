package com.yongjae_project.shopping_app.presentation.view.search.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.component.ClearIcon
import com.yongjae_project.shopping_app.presentation.component.SearchIcon

@Composable
fun SearchHistoryItemView(searchHistoryItem: SearchHistoryItem) {
    Box(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp).background(color = Color.Cyan),
        contentAlignment = Alignment.CenterStart
    ) {
        Row {
            SearchIcon(Color.Gray)
            Spacer(Modifier.size(4.dp))
            Text(searchHistoryItem.searchText)
            Box(
                modifier =
                Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Box{
                Row {
                    Text(searchHistoryItem.searchAt)
                    Spacer(Modifier.size(4.dp))
                    ClearIcon()
                }
            }
        }
    }
}