package com.ldev.newsfeed.feature.bookmarks_screen.ui

import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

data class ViewState(
    val articles: List<ArticleDomainModel>,
    val article: ArticleDomainModel?
)

sealed class UiEvent : Event {
    data class OnBookmarkClick(val articleDomainModel: ArticleDomainModel) : UiEvent()
    data class OnBookmarksFetched(val articles: List<ArticleDomainModel>) : UiEvent()
    data class OnArticleClick(val article: ArticleDomainModel) : UiEvent()
}

sealed class DataEvent : Event {
    object RefreshDataBase : DataEvent()
}