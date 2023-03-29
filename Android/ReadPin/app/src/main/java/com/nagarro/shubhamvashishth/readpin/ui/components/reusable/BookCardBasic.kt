package com.nagarro.shubhamvashishth.readpin.ui.components.reusable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.nagarro.shubhamvashishth.readpin.R

@Composable
fun basicBookCard(olid: String?, title:String, like: (Unit)->Unit  ){

   val url= "https://covers.openlibrary.org/b/olid/${olid?:""}-L.jpg"
    Box(Modifier.padding(20.dp)) {

        Column {

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .diskCachePolicy(CachePolicy.ENABLED)
                .size(400, 700).scale(Scale.FILL)
                .build(),
            contentDescription = "Just the image randomly",
            Modifier
                .width(128.8.dp)
                .height(200.dp),
            placeholder = debugPlaceholder(R.drawable.ic_launcher_background),
            error = debugPlaceholder(R.drawable.ic_launcher_background)
        )
        Text(text = title, Modifier.width(128.8.dp), overflow = TextOverflow.Visible, maxLines = 2)
    }
}

}

@Composable
fun debugPlaceholder(@DrawableRes debugPreview: Int) =
    if (LocalInspectionMode.current) {
        painterResource(id = debugPreview)
    } else {
        null
    }

@Preview
@Composable
fun basicBookCoverPreview(){
    basicBookCard(olid = "OL30570882M", "Atomic habits", like = { })
}

