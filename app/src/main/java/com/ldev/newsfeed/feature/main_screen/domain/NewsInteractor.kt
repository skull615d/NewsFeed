package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.base.attempt
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import java.util.*

class NewsInteractor(private val repo: MainScreenRepo) {
    suspend fun getNews() = attempt {
        repo.getNews().filter { article ->
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, -1)
            article.publishedAt?.let { it < calendar } ?: false
        }
    }
}