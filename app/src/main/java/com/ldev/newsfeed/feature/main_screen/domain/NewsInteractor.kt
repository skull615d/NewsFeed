package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.base.attempt
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo

class NewsInteractor (private val repo: MainScreenRepo) {
    suspend fun getNews() = attempt {
        repo.getNews()
    }
}