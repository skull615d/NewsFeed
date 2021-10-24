package com.ldev.newsfeed.feature.main_screen.ui

import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

data class ViewState(
    val articles: List<ArticleDomainModel>,
    val errorMessage: String?,
    val isLoading: Boolean,
) {
    val isInErrorState: Boolean = errorMessage != null
}

sealed class UiEvent : Event {
    object GetNews : UiEvent()
    data class OnBookmarksFetched(val articles: List<ArticleDomainModel>) : UiEvent()
    data class OnArticleClick(val article: ArticleDomainModel) : UiEvent()
    data class OnBookmarkClick(val article: ArticleDomainModel) : UiEvent()
}

sealed class DataEvent : Event {
    data class SuccessNewsRequest(val articleDomainModelList: List<ArticleDomainModel>) :
        DataEvent()

    data class ErrorNewsRequest(val errorMessage: String) : DataEvent()
}