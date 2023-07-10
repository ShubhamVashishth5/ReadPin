package com.nagarro.shubhamvashishth.readpin.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import com.nagarro.shubhamvashishth.readpin.model.trending.WorksWeekly
import com.nagarro.shubhamvashishth.readpin.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val repository= DataRepository()

    private var _bookList = MutableStateFlow(WeeklyTrending(mutableListOf()));
    var bookList: StateFlow<WeeklyTrending> = _bookList


    fun updateWeeklyList(){
        viewModelScope.launch {
            _bookList.emit( WeeklyTrending(repository.getWeeklyTrendingBooks() as MutableList<WorksWeekly>))
            Log.d("Check", "Temp value has been updated"+ bookList.value.works[1].title)
        }
    }


}