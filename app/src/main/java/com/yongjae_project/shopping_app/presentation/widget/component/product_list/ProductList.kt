package com.yongjae_project.shopping_app.presentation.widget.component.product_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.presentation.view.product_list.ProductListViewModel
import com.yongjae_project.shopping_app.presentation.widget.atom.OnBottomReached
import com.yongjae_project.shopping_app.util.SHOPPING_API_DISPLAY_SIZE

@Composable
fun ProductList(
    items: List<ProductItem>,
    productListViewModel: ProductListViewModel,
) {
    val state = rememberLazyListState()
    Divider(color = Color.Gray)
    LazyColumn(state = state) {
        items(count = items.size) { index ->
            ProductListItem(items[index])
            Divider(color = Color.LightGray)
        }
    }
    state.OnBottomReached {
        productListViewModel.addProductList((items.size / SHOPPING_API_DISPLAY_SIZE) + 1)
    }
}