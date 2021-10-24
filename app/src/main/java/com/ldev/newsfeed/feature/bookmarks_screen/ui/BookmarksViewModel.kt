package com.ldev.newsfeed.feature.bookmarks_screen.ui

import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.ldev.newsfeed.base.BaseViewModel
import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.feature.bookmarks_screen.domain.BookmarksInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BookmarksViewModel(private val interactor: BookmarksInteractor) : BaseViewModel<ViewState>() {

    init {
        viewModelScope.launch {
            interactor.subscribeByAddDateTime().asFlow().collect {
                processUiEvent(UiEvent.OnBookmarksFetched(articles = it))
            }
        }
    }

    override fun initialViewState(): ViewState = ViewState(emptyList(), article = null)

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.RefreshDataBase -> {
                val newArticleList = interactor.read()
                return previousState.copy(articles = newArticleList)
            }

            is UiEvent.OnBookmarksFetched -> {
                return previousState.copy(articles = event.articles)
            }

            is UiEvent.OnBookmarkClick -> {
                interactor.delete(event.articleDomainModel)
            }
        }
        return null
    }
}