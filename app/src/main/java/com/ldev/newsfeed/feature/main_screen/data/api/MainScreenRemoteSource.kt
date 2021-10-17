package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenModel

class MainScreenRemoteSource(private val api: MainScreenApi) {
    suspend fun getNews(): MainScreenModel{
        return api.getNews()
    }
}