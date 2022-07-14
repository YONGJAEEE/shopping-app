package com.yongjae_project.shopping_app.presentation.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yongjae_project.shopping_app.presentation.model.Pages
import com.yongjae_project.shopping_app.presentation.ui.theme.Shopping_appTheme
import com.yongjae_project.shopping_app.presentation.view.result.ResultPage
import com.yongjae_project.shopping_app.presentation.view.search.SearchPage
import com.yongjae_project.shopping_app.presentation.view.search.SearchViewModel
import com.yongjae_project.shopping_app.presentation.widget.component.main.MainSearchButton
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
                    val navController = rememberNavController()
                    val searchViewModel: SearchViewModel by viewModels()
                    NavigationComponent(navController, searchViewModel)
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun NavigationComponent(navController: NavHostController, searchViewModel: SearchViewModel) {
    NavHost(
        navController = navController,
        startDestination = Pages.MAIN.name
    ) {
        composable(Pages.MAIN.name) {
            MainPage(navController)
        }
        composable(Pages.SEARCH.name) {
            SearchPage(navController, searchViewModel)
        }
        composable(Pages.RESULT.name) {
            ResultPage(navController)
        }
    }
}


@Composable
@ExperimentalComposeUiApi
fun MainPage(navController : NavHostController) {
    Scaffold {
        MainSearchButton(navController)
    }
}