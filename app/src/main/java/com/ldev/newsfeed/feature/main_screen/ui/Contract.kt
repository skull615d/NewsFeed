package com.ldev.newsfeed.feature.main_screen.ui

import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

data class ViewState(
    val articles: List<ArticleDomainModel>,
    val errorMessage: String?,
    val isLoading: Boolean,
)

sealed class UiEvent : Event {
    object GetCurrentNews : UiEvent()
    data class OnArticleClick(val article: ArticleDomainModel) : UiEvent()
    data class OnBookmarkClick(val article: ArticleDomainModel) : UiEvent()
}

sealed class DataEvent : Event {
    object OnLoadData : DataEvent()
    data class SuccessNewsRequest(val articleDomainModelList: List<ArticleDomainModel>) :
        DataEvent()

    data class ErrorNewsRequest(val errorMessage: String) : DataEvent()
}