package com.ldev.newsfeed.feature.main_screen.domain

import com.ldev.newsfeed.base.attempt
import com.ldev.newsfeed.base.mapToList
import com.ldev.newsfeed.feature.bookmarks_screen.data.BookmarksRepo
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.utils.lastTime

class NewsInteractor(
    private val mainScreenRepo: MainScreenRepo,
    private val bookmarkRepo: BookmarksRepo
) {
    suspend fun getNews() = attempt {
        val news = mainScreenRepo.getNews().lastTime(24)
        val bookmarks = bookmarkRepo.read()
        mapToList(oldList = news, newList = bookmarks)
    }
}