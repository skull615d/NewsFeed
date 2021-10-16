package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenModel
import retrofit2.http.GET
import retrofit2.http.Query

// GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
// API_KEY = 069fba9867bf43c38102c578733e009a
interface MainScreenApi {
    @GET("v2/top-headlines")
    fun getNews(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey:String = "069fba9867bf43c38102c578733e009a"
    ): MainScreenModel
}