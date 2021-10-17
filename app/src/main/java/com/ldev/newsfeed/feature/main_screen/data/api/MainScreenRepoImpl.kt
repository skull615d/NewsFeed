package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.toDomain
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

class MainScreenRepoImpl(private val source: MainScreenRemoteSource): MainScreenRepo{
    override suspend fun getNews(): List<MainScreenDomainModel> {
        return source.getNews().articles.map { it.toDomain() }
    }
}