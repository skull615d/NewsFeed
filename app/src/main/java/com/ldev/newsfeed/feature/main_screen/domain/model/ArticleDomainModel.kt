package com.ldev.newsfeed.feature.main_screen.domain.model

import java.util.*

data class ArticleDomainModel(
    val source: ArticleSourceDomainModel,
    val author: String,
    val title: String,
    val descriptions: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: Calendar?,
    val content: String,
    val isBookmark: Boolean
)