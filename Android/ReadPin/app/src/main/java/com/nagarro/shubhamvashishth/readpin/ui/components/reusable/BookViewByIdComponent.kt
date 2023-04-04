package com.nagarro.shubhamvashishth.readpin.ui.components.reusable

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.google.gson.Gson
import com.nagarro.shubhamvashishth.readpin.constants.DEBUG_LOG
import com.nagarro.shubhamvashishth.readpin.viewmodels.BookViewByIdViewModel


@Composable
fun viewBookById(navController: NavController, bookId:String, coverId:String){

    Log.d(DEBUG_LOG, navController.currentDestination!!.route.toString())

    Log.d(DEBUG_LOG, bookId+coverId)

    var bookViewModel: BookViewByIdViewModel = viewModel()

    val book by bookViewModel.book.collectAsState()

    if(book==null){
        bookViewModel.loadBook(bookId)
    }

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


    book?.let{
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(2.dp, 5.dp)){

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight / 3)
                .clip(RoundedCornerShape(5.dp))
                .background(Color.Cyan), contentAlignment = Alignment.Center) {

                Row( verticalAlignment = Alignment.Top) {

                    var url= if(it.covers == null)
                        "https://covers.openlibrary.org/b/olid/${it.key.substringAfterLast('/')?:""}-L.jpg"
                    else
                        "https://covers.openlibrary.org/b/id/${it.covers[0]}-L.jpg"


                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(url)
                            .crossfade(true)
                            .diskCachePolicy(CachePolicy.ENABLED)
                            .size(400, 700).scale(Scale.FILL)
                            .build(),
                        contentDescription = "Just the image randomly",
                        Modifier
                            .width(screenWidth / 3)
                            .height(screenHeight / 2),
                    )

                    Text(text = book!!.title, fontSize = 30.sp, textAlign = TextAlign.Center )


                }
            }

        }


    }


}

@Preview
@Composable
fun prev(){
    viewBookById(navController = rememberNavController(), bookId = "OL28914133W" , coverId = "13161561")
}
