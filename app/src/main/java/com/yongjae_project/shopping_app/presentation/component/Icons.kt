package com.yongjae_project.shopping_app.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor

@Composable
fun BackIcon(color : Color? = null) {
    Icon(
        imageVector = Icons.Filled.ArrowBack,
        contentDescription = "",
        tint = color ?: Color.Black,
    )
}

@Composable
fun SearchIcon(color : Color? = null) {
    Icon(
        imageVector = Icons.Filled.Search,
        contentDescription = "",
        tint = color ?: MainColor,
    )
}

@Composable
fun ClearIcon(color : Color? = null) {
    Icon(
        imageVector = Icons.Default.Clear,
        contentDescription = "",
        tint = color ?: Color.Gray,
    )
}
