package com.yongjae_project.shopping_app.presentation.view.product_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.presentation.widget.atom.BackIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.TransparentButton
import com.yongjae_project.shopping_app.presentation.widget.component.product_list.ProductList

@Composable
fun ProductListPage(
    query: String,
    navController: NavHostController,
    productListViewModel: ProductListViewModel,
) {
    productListViewModel.searchProductList(query)
    val items: List<ProductItem> by productListViewModel.productList.observeAsState(listOf())

    Scaffold {
        Column {
            TransparentButton(
                modifier = Modifier.size(50.dp),
                onClick = {
                    navController.popBackStack()
                },
                content = { BackIcon() }
            )
            if (items.isNotEmpty()) {
                ProductList(items, productListViewModel)
            } else TransparentButton()
        }
    }
}