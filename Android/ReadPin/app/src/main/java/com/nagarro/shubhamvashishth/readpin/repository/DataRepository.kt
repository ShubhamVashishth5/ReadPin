package com.nagarro.shubhamvashishth.readpin.repository

import com.nagarro.shubhamvashishth.readpin.api.BooksAPI
import com.nagarro.shubhamvashishth.readpin.api.RetrofitHelper
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import com.nagarro.shubhamvashishth.readpin.model.trending.WorksWeekly
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.create

class DataRepository {

    val networkDataRepository = RetrofitHelper.instance.create(BooksAPI::class.java)

    /**
     * Get weekly trending books
     * @param: nothing
     * @return: List of books
     */
    suspend fun getWeeklyTrendingBooks(): List<WorksWeekly>{

        var list : WeeklyTrending? = null
        val result=  CompletableDeferred<List<WorksWeekly>>()
        CoroutineScope(Dispatchers.IO).launch {
            list= networkDataRepository.getWeeklyTrending().body()!!
        }.join()
        return list!!.works
    }

}