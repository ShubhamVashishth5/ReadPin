package com.nagarro.shubhamvashishth.readpin.api

import com.nagarro.shubhamvashishth.readpin.model.Author
import com.nagarro.shubhamvashishth.readpin.model.Book
import com.nagarro.shubhamvashishth.readpin.model.trending.WeeklyTrending
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksAPI {

    /**
     * Get list of weekly trending works
     * @return WeeklyTrending
     */
    @GET("/trending/weekly.json")
    suspend fun getWeeklyTrending() : Response<WeeklyTrending>

    /**
     * Get a work by its OLID
     * @param olId
     * @return Book
     */
    @GET("works/{olid}.json")
    suspend fun getBookById(@Path("olid") olId:String): Response<Book>

    /**
     * Get author by author id
     * @param authorId
     * @return Author
     */
    @GET("authors/{authorId}.json")
    suspend fun getAuthorById(@Path("authorId") authorId:String ) : Response<Author>


}