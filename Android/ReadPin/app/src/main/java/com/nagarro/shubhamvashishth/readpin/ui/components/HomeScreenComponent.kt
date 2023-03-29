package com.nagarro.shubhamvashishth.readpin.ui.components

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nagarro.shubhamvashishth.readpin.api.BooksAPI
import com.nagarro.shubhamvashishth.readpin.api.RetrofitHelper
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import com.nagarro.shubhamvashishth.readpin.model.trending.WorksWeekly
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.basicBookCard
import com.nagarro.shubhamvashishth.readpin.ui.components.reusable.featureLockedLogin
import com.nagarro.shubhamvashishth.readpin.viewmodels.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.create

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun homeScreen(navController: NavHostController){

    var viewModel: HomeViewModel = viewModel()

    var list by remember{ mutableStateOf(  WeeklyTrending(mutableListOf<WorksWeekly>()) ) }

    viewModel.updateWeeklyList()

    val list2 by viewModel.temp.collectAsState()



    Column {
        featureLockedLogin()
        LazyRow{

            list2?.let {
                items(it.works){
                    //Text(text = it.cover_edition_key+ " " + it.title)
                    basicBookCard(olid = it.cover_edition_key, it.title, like = {})
                }
            }
        }
    }


}