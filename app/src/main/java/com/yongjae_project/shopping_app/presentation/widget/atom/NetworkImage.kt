package com.yongjae_project.shopping_app.presentation.widget.atom

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun NetworkImage(url: String, modifier: Modifier = Modifier){
    Box(modifier = modifier, content = {
        GlideImage(
            imageModel = url,
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(duration = 250),
            placeHolder = ImageBitmap(width = 50, height = 50),
            error = ImageBitmap(width = 50, height = 50),
        )
    })

}