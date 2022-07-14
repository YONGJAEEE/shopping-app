package com.yongjae_project.shopping_app.presentation.view.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.presentation.widget.atom.BackIcon

@Composable
fun ResultPage(navController: NavHostController) {
    Scaffold {
        Column {
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                elevation = ButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                ),
                modifier = Modifier.size(30.dp),
                contentPadding = PaddingValues(all = 0.dp),
                onClick = {
                    navController.popBackStack()
                },
            ) {
                BackIcon()
            }
        }
    }
}