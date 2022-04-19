package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.base.attempt
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.utils.lastTime

class NewsInteractor(
    private val mainScreenRepo: MainScreenRepo
) {
    suspend fun getNews() = attempt {
        mainScreenRepo.getNews().lastTime(24)
    }
}