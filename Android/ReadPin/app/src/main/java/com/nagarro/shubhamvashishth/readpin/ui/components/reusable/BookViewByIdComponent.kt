package com.nagarro.shubhamvashishth.readpin.ui.components.reusable

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import com.nagarro.shubhamvashishth.readpin.constants.DEBUG_LOG
import com.nagarro.shubhamvashishth.readpin.constants.NETWORK_LOG
import com.nagarro.shubhamvashishth.readpin.constants.VALUE_CHECK_LOG
import com.nagarro.shubhamvashishth.readpin.constants.VIEW_AUTHOR_ROUTE
import com.nagarro.shubhamvashishth.readpin.viewmodels.BookViewByIdViewModel


@Composable
fun viewBookById(navController: NavHostController,
                 bookId:String,
                 coverId:String){

    Log.d(DEBUG_LOG, navController.currentDestination!!.route.toString())

    Log.d(DEBUG_LOG, bookId+coverId)

    var bookViewModel: BookViewByIdViewModel = viewModel()

    val book by bookViewModel.book.collectAsState()
    var isExpanded by remember{ mutableStateOf(false) }
    var maxLines = if (isExpanded)100 else 4

    if(book==null){
        bookViewModel.loadBook(bookId)
    }

    val configuration = LocalConfiguration.current

    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp


    book?.let{
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(5.dp, 5.dp)){

            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState())) {

            Card(elevation = 5.dp, modifier = Modifier
                .align(Alignment.Start)
                .padding(5.dp)
                .fillMaxWidth()
                .height(screenHeight / 2.5f)){

                Row( verticalAlignment = Alignment.Top, modifier = Modifier.padding(5.dp)) {

                    var coverUrl ="https://covers.openlibrary.org/b/id/${coverId}-L.jpg"

                    Log.d(NETWORK_LOG,coverUrl)

                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(coverUrl)
                            .crossfade(true)
                            .diskCachePolicy(CachePolicy.ENABLED)
                            .size(Size.ORIGINAL).scale(Scale.FILL)
                            .build(),
                        contentDescription = "Just the image randomly",
                        Modifier
                            .width(screenWidth / 3)
                            .height(screenHeight / 2.8f), contentScale = ContentScale.FillBounds
                    )

                    Column {
                        Text(text = book!!.title, fontSize = 30.sp, textAlign = TextAlign.Center)
                        Text(text = it.author.name, Modifier.clickable {
                            navController.navigate(
                                "view/author/"+
                                        it.authors.first().author.key.substringAfterLast('/')+
                                        "/4")
                        })
                    }

                }
            }
                

                Log.d(VALUE_CHECK_LOG,it.actualDescription)
                Text(text = it.actualDescription,
                    color = Color.Black, overflow = TextOverflow.Ellipsis,
                    maxLines = maxLines, modifier = Modifier
                        .clickable {
                            isExpanded = !isExpanded
                        }
                        .animateContentSize(
                            animationSpec = tween(
                                durationMillis = 300,
                                easing = LinearOutSlowInEasing
                            )
                        )
                        .fillMaxWidth())

                it.subjects?.let {subject->
                    showSubjects(isExpanded = isExpanded, subjects = subject)
                }

            }
        }
    }

}

@Composable
fun showSubjects(isExpanded:Boolean, subjects:List<String>){

    LazyRow{
        items(subjects){
            Box(modifier = Modifier
                .padding(3.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(Color(4289243045))){
                Text(text = it, Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun prev(){
    viewBookById(navController = rememberNavController(), bookId = "OL28914133W" , coverId = "13161561")
}
