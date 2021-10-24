package com.ldev.newsfeed.feature.bookmarks_screen.data

import com.ldev.newsfeed.feature.bookmarks_screen.data.local.BookmarksEntity
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.utils.toCalendar
import com.ldev.newsfeed.utils.toStringFormat

fun ArticleDomainModel.toEntityModel() = BookmarksEntity(
    url = url,
    author = author,
    title = title,
    descriptions = descriptions,
    publishedAt = publishedAt?.toStringFormat() ?: "",
    urlToImage = urlToImage,
    isBookmarked = isBookmarked,
    addBookmarkDateTime = addBookmarkDateTime
)

fun BookmarksEntity.toDomainModel() = ArticleDomainModel(
    url = url,
    author = author,
    title = title,
    descriptions = descriptions,
    publishedAt = publishedAt.toCalendar("dd.MM.yyyy HH:mm"),
    urlToImage = urlToImage,
    isBookmarked = isBookmarked,
)