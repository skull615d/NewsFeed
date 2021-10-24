package com.ldev.newsfeed.feature.main_screen.data

import com.ldev.newsfeed.feature.main_screen.data.api.model.ArticleModel
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.utils.toCalendar


fun ArticleModel.toDomain() = ArticleDomainModel(
    author ?: "",
    title,
    description ?: "",
    url,
    urlToImage ?: "",
    publishedAt = publishedAt.toCalendar(),
    isBookmarked = false
)
