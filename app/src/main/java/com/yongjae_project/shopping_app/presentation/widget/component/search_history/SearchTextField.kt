package com.yongjae_project.shopping_app.presentation.widget.component.search_history

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.yongjae_project.shopping_app.R
import com.yongjae_project.shopping_app.extensions.showToast
import com.yongjae_project.shopping_app.presentation.ui.theme.MainColor
import com.yongjae_project.shopping_app.presentation.view.search.SearchViewModel
import com.yongjae_project.shopping_app.presentation.widget.atom.BackIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.SearchIcon
import com.yongjae_project.shopping_app.presentation.widget.atom.TransparentButton

@ExperimentalComposeUiApi
@Composable
fun SearchTextField(navController: NavHostController, searchViewModel: SearchViewModel) {
    val textState: MutableState<String> = remember { mutableStateOf("") }
    val context = LocalContext.current
    val enterWordMessage = stringResource(id = R.string.please_enter_word)
    Column(
        content = {
            TextField(
                value = textState.value,
                placeholder = { Text(enterWordMessage) },
                onValueChange = { textState.value = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 4.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    TransparentButton(
                        modifier = Modifier.size(30.dp),
                        onClick = {
                            navController.popBackStack()
                        },
                        content = { BackIcon() }
                    )
                },
                trailingIcon = {
                    TransparentButton(
                        modifier = Modifier.size(30.dp),
                        onClick = {
                            if (textState.value != "") {
                                searchViewModel.addSearchHistory(textState.value)
                                textState.value = ""
                            } else {
                                context.showToast(enterWordMessage)
                            }
                        },
                        content = { SearchIcon() }
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                )
            )
            Divider(color = MainColor)
        }
    )
}