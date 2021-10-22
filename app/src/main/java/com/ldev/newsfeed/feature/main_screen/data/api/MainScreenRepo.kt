package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

interface MainScreenRepo {
    suspend fun getNews(): List<ArticleDomainModel>
}