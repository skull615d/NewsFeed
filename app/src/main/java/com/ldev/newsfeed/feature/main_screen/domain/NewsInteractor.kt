package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

class NewsInteractor (private val repo: MainScreenRepo) {
    suspend fun getNews(): List<MainScreenDomainModel>{
        return repo.getNews()
    }
}