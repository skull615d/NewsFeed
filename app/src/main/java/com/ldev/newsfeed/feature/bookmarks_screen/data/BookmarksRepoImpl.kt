package com.ldev.newsfeed.feature.bookmarks_screen.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.ldev.newsfeed.feature.bookmarks_screen.data.local.BookmarksDAO
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

class BookmarksRepoImpl(private val bookmarksDAO: BookmarksDAO) : BookmarksRepo {

    override suspend fun create(articleDomainModel: ArticleDomainModel) {
        bookmarksDAO.create(articleDomainModel.toEntityModel())
    }

    override suspend fun read(): List<ArticleDomainModel> {
        return bookmarksDAO.read().map { it.toDomainModel() }
    }

    override suspend fun update(articleDomainModel: ArticleDomainModel) {
        bookmarksDAO.update(articleDomainModel.toEntityModel())
    }

    override suspend fun delete(articleDomainModel: ArticleDomainModel) {
        bookmarksDAO.delete(articleDomainModel.toEntityModel())
    }

    override suspend fun subscribeByAddDateTime(): LiveData<List<ArticleDomainModel>> {
        return bookmarksDAO.subscribeByAddDateTime()
            .map { liveData -> liveData.map { it.toDomainModel() } }
    }
}