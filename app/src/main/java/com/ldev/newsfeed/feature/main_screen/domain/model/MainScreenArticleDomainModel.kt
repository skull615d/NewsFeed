package com.ldev.newsfeed.feature.main_screen.domain.model

import com.google.gson.annotations.SerializedName
import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenSourceModel

class MainScreenArticleDomainModel(
    val source: MainScreenSourceModel,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) {
}