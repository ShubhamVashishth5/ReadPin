package com.nagarro.shubhamvashishth.readpin.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.basicBookCard
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.bookPlaceholderShimmer
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.featureLockedLogin
import com.nagarro.shubhamvashishth.readpin.viewmodels.HomeViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun homeScreen(navController: NavHostController){

    var viewModel : HomeViewModel = viewModel()


    val bookList by viewModel.bookList.collectAsState()

    Log.d("Hello", bookList.works.size.toString())

    if (bookList.works.size==0){    viewModel.updateWeeklyList()
    }

    var isLoading by remember {
        mutableStateOf(true)
    }


    Column {
        featureLockedLogin()

        if(isLoading) {
            bookPlaceholderShimmer()
        }
        LazyRow{
            bookList?.let {
                items(it.works){
                    //Text(text = it.cover_edition_key+ " " + it.title)
                    basicBookCard(olid = it.cover_edition_key, it.title,
                        like = {navController
                            .navigate("view/"+it.key.substringAfterLast('/')+ "/{${it.cover_i}}")
                        }
                    )

                    isLoading=false
                }
            }
        }
    }


}