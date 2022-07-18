package com.yongjae_project.shopping_app.presentation.widget.component.product_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.presentation.widget.atom.NetworkImage

@Composable
fun ProductListItem(item: ProductItem){
    Row {
        NetworkImage(url= item.image, modifier = Modifier.size(50.dp))
        Column {

        }
    }
}