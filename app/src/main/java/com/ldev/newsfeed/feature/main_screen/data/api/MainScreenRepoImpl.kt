package com.ldev.newsfeed.feature.main_screen.data.api

import com.ldev.newsfeed.feature.main_screen.data.toDomain
import com.ldev.newsfeed.feature.main_screen.domain.model.MainScreenDomainModel

class MainScreenRepoImpl(private val source: MainScreenRemoteSource): MainScreenRepo{
    override fun getNews(): MainScreenDomainModel {
        return source.getNews().toDomain()
    }
}