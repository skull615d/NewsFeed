package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

interface MainScreenRepo {
    suspend fun getNews(): List<MainScreenDomainModel>
}