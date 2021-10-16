package com.ldev.newsfeed.feature.main_screen.domain.model

class MainScreenDomainModel(
    val source: MainScreenSourceDomainModel,
    val author: String,
    val title: String,
    val descriptions: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
    ) {
}