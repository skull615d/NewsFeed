package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.*

// GET https://newsapi.org/v2/top-headlines?country=ru&apiKey=069fba9867bf43c38102c578733e009a
// API_KEY = 069fba9867bf43c38102c578733e009a

//https://newsapi.org/v2/everything?q=tesla&from=2021-09-16&sortBy=popularity&apiKey=069fba9867bf43c38102c578733e009a
//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY - Получите последние заголовки новостей для страны или категории
interface MainScreenApi {
    @GET("v2/top-headlines")
    @Headers("X-Api-Key: 069fba9867bf43c38102c578733e009a")
    suspend fun getNews(

        @Query("country") country: String = Locale.getDefault().country

    ): MainScreenModel
}