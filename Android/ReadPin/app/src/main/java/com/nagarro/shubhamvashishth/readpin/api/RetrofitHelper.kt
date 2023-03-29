package com.nagarro.shubhamvashishth.readpin.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper {
    val baseUrl= "https://openlibrary.org/"

    var interceptor=HttpLoggingInterceptor().apply {
        level=HttpLoggingInterceptor.Level.BASIC
    }
    var client: OkHttpClient = OkHttpClient.Builder().callTimeout(30,TimeUnit.SECONDS).addInterceptor(interceptor).build()


    var instance: Retrofit =Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}