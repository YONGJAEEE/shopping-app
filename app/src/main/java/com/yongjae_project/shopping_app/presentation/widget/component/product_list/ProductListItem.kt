package com.yongjae_project.shopping_app.presentation.widget.component.product_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yongjae_project.shopping_app.R
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.presentation.widget.atom.HtmlText
import com.yongjae_project.shopping_app.presentation.widget.atom.NetworkImage

@Composable
fun ProductListItem(item: ProductItem){
    Row(
        modifier = Modifier.padding(PaddingValues(all = 15.dp))
    ) {
        NetworkImage(url= item.image, modifier = Modifier.size(150.dp))
        Box(modifier = Modifier.width(15.dp))
        Column {
            Box(modifier = Modifier.height(10.dp))
            HtmlText(item.title)
            Box(modifier = Modifier.height(5.dp))
            Text("${stringResource(R.string.lprice_title)} ${item.lprice}${stringResource(R.string.monetary_unit_title)}")
        }
    }
}