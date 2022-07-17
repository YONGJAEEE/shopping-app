package com.yongjae_project.shopping_app.presentation.view.product_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import com.yongjae_project.shopping_app.presentation.widget.atom.BackIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.TransparentButton
import com.yongjae_project.shopping_app.presentation.widget.component.product_list.ProductList

@Composable
fun ProductListPage(navController: NavHostController, productListViewModel: ProductListViewModel) {
    val items: List<ProductItem> by productListViewModel.productList.observeAsState(listOf())
    Scaffold {
        Column {
            TransparentButton(
                modifier = Modifier.size(30.dp),
                onClick = {
                    navController.popBackStack()
                },
                content = { BackIcon() }
            )
            ProductList(items)
        }
    }
}