package com.ldev.newsfeed.feature.bookmarks_screen.data

import androidx.lifecycle.LiveData
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

interface BookmarksRepo {
    suspend fun create(articleDomainModel: ArticleDomainModel)
    suspend fun read(): List<ArticleDomainModel>
    suspend fun update(articleDomainModel: ArticleDomainModel)
    suspend fun delete(articleDomainModel: ArticleDomainModel)
    suspend fun subscribeByAddDateTime(): LiveData<List<ArticleDomainModel>>
}