package com.yongjae_project.shopping_app.presentation.view.product_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.data.model.ProductItem
import com.yongjae_project.shopping_app.data.model.RemoteResult
import com.yongjae_project.shopping_app.extensions.showToast
import com.yongjae_project.shopping_app.presentation.widget.atom.BackIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.NoDataText
import com.yongjae_project.shopping_app.presentation.widget.atom.TransparentButton
import com.yongjae_project.shopping_app.presentation.widget.component.product_list.ProductList

@Composable
fun ProductListPage(
    query: String,
    navController: NavHostController,
    productListViewModel: ProductListViewModel,
) {
    productListViewModel.searchProductList(query)
    val result: RemoteResult<List<ProductItem>>? by productListViewModel.productResult.observeAsState()

    Scaffold {
        Column {
            TransparentButton(
                modifier = Modifier.size(50.dp),
                onClick = {
                    navController.popBackStack()
                },
                content = { BackIcon() }
            )
            when(result){
                is RemoteResult.Success -> {
                    if (result!!.data!!.isNotEmpty()) {
                        ProductList(result!!.data!!, productListViewModel)
                    } else NoDataText()
                }
                is RemoteResult.Error -> {
                    LocalContext.current.showToast(result?.message ?: "Unknown Error occurred.")
                    NoDataText()
                }
            }
        }
    }
}