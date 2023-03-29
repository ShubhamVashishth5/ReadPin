package com.nagarro.shubhamvashishth.readpin.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import com.nagarro.shubhamvashishth.readpin.model.trending.WorksWeekly
import com.nagarro.shubhamvashishth.readpin.repository.DataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val repository= DataRepository()

    var _temp = MutableStateFlow<WeeklyTrending>(WeeklyTrending(mutableListOf()));
    var temp: StateFlow<WeeklyTrending> = _temp


    fun updateWeeklyList(){
        viewModelScope.launch {
            _temp.emit( WeeklyTrending(repository.getWeeklyTrendingBooks() as MutableList<WorksWeekly>))
            Log.d("Check", "Temp value has been updated"+ temp.value.works[1].title)
        }
    }


}