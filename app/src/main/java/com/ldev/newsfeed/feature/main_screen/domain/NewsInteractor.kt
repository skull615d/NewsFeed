package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

class NewsInteractor (val repo: MainScreenRepo) {
    fun getNews(): List<MainScreenDomainModel>{
        return repo.getNews()
    }
}