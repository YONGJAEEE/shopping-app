package com.yongjae_project.shopping_app.presentation.widget.component.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor
import com.yongjae_project.shopping_app.presentation.widget.atom.SearchIcon
import com.yongjae_project.shopping_app.util.Pages

@Composable
@ExperimentalComposeUiApi
fun MainSearchButton(navController : NavHostController) {
    Button(
        onClick = {
            navController.navigate(Pages.SEARCH.name)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
        border = BorderStroke(width = 1.dp, color = MainColor),
        modifier = Modifier.padding(all = 16.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box() { SearchIcon() }
            Box(
                modifier =
                Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            ) {}
        }
    }
}