package com.ldev.newsfeed.feature.bookmarks_screen.domain

import androidx.lifecycle.LiveData
import com.ldev.newsfeed.feature.bookmarks_screen.data.BookmarksRepo
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

class BookmarksInteractor(private val repo: BookmarksRepo) {
    suspend fun create(articleDomainModel: ArticleDomainModel) = repo.create(articleDomainModel)
    suspend fun read(): List<ArticleDomainModel> = repo.read()
    suspend fun update(articleDomainModel: ArticleDomainModel) = repo.update(articleDomainModel)
    suspend fun delete(articleDomainModel: ArticleDomainModel) = repo.delete(articleDomainModel)
    suspend fun subscribeByAddDateTime(): LiveData<List<ArticleDomainModel>> =
        repo.subscribeByAddDateTime()
}