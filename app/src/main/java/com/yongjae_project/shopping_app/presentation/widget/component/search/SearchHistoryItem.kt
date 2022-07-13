package com.yongjae_project.shopping_app.presentation.widget.component.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.widget.atom.ClearIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.SearchIcon
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SearchHistoryItemView(searchHistoryItem: SearchHistoryItem, clearButtonTapEvent: () -> Unit) {

    val dateFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH)
    val searchAt: Date = dateFormat.parse(searchHistoryItem.searchAt)!!

    Box(
        modifier = Modifier
            .height(45.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row {
            SearchIcon(Color.Gray)
            Spacer(Modifier.size(4.dp))
            Text(
                searchHistoryItem.searchText,
                modifier = Modifier.width(250.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Box(
                modifier =
                Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
            Text(
                text = "${searchAt.month + 1}.${searchAt.date}", //TODO- Refactor with not deprecated code
                maxLines = 1
            )
            Spacer(Modifier.size(4.dp))
            Button(
                onClick = clearButtonTapEvent,
                elevation = elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                ),
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(all = 0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            ) {
                ClearIcon()
            }
        }
    }
}