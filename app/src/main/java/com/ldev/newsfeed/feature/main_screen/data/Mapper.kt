package com.ldev.newsfeed.feature.main_screen.data

import com.ldev.newsfeed.feature.main_screen.data.api.model.ArticleModel
import com.ldev.newsfeed.feature.main_screen.data.api.model.ArticleSourceModel
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleSourceDomainModel
import com.ldev.newsfeed.utils.toCalendar

fun ArticleSourceModel.toDomain() = ArticleSourceDomainModel(name = name)

fun ArticleModel.toDomain() = ArticleDomainModel(
    source = source.toDomain(),
    author ?: "",
    title,
    description ?: "",
    url,
    urlToImage ?: "",
    publishedAt = publishedAt.toCalendar("yyyy-MM-dd'T'HH:mm:ss"),
    content ?: "",
    isBookmark = false
)
