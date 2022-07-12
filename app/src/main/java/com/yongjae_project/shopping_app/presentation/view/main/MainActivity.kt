package com.yongjae_project.shopping_app.presentation.view.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.presentation.component.SearchIcon
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor
import com.yongjae_project.shopping_app.presentation.ui.theme.Shopping_appTheme
import com.yongjae_project.shopping_app.presentation.view.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Shopping_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
@ExperimentalComposeUiApi
fun MainPage() {
    Scaffold() {
        SearchButton()
    }
}

@Composable
@ExperimentalComposeUiApi
fun SearchButton() {
    val context = LocalContext.current
    Button(
        onClick = {
            context.startActivity(Intent(context, SearchActivity::class.java))
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


@Preview(showBackground = true)
@Composable
@ExperimentalComposeUiApi
fun DefaultPreview() {
    Shopping_appTheme {
        MainPage()
    }
}