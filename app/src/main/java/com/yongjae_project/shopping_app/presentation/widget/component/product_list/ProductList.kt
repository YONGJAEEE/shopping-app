package com.yongjae_project.shopping_app.presentation.widget.component.product_list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.yongjae_project.shopping_app.data.model.ProductItem

@Composable
fun ProductList(items: List<ProductItem>){
    LazyColumn {
        items(count = items.size) { index ->
            val item = items[index]
            ProductListItem(item)
        }
    }
}