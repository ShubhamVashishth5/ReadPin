package com.nagarro.shubhamvashishth.readpin.api

import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import retrofit2.Response
import retrofit2.http.GET

interface BooksAPI {

    @GET("/trending/weekly.json")
    suspend fun getWeeklyTrending() : Response<WeeklyTrending>

}