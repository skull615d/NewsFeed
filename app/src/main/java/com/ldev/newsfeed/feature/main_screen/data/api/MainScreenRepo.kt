package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

interface MainScreenRepo {
    fun getNews(): List<MainScreenDomainModel>
}