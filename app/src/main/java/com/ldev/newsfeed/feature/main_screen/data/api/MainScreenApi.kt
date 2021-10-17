package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
// API_KEY = 069fba9867bf43c38102c578733e009a

//https://newsapi.org/v2/everything?q=tesla&from=2021-09-16&sortBy=popularity&apiKey=069fba9867bf43c38102c578733e009a
//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY - Получите последние заголовки новостей для страны или категории
interface MainScreenApi {
    @GET("v2/top-headlines")
    @Headers("X-Api-Key: 069fba9867bf43c38102c578733e009a")
    suspend fun getNews(
        //@Query("q") q: String = "tesla",
        //@Query("language") language: String = "ru",//ar de en es fr he it nl no pt ru se ud zh.
        //@Query("from") from: String = "2021-10-16",
        //@Query("sortBy") sortBy: String = "popularity",
        @Query("country") country: String = "ru"

    ): MainScreenModel
}