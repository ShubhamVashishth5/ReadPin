package com.nagarro.shubhamvashishth.readpin.api

import com.nagarro.shubhamvashishth.readpin.model.trending.Book
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksAPI {

    @GET("/trending/weekly.json")
    suspend fun getWeeklyTrending() : Response<WeeklyTrending>

    @GET("works/{olid}.json")
    suspend fun getBookById(@Path("olid") olId:String): Response<Book>


}