package com.ldev.newsfeed.feature.main_screen.ui

import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.ldev.newsfeed.base.BaseViewModel
import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.base.mapToList
import com.ldev.newsfeed.feature.bookmarks_screen.domain.BookmarksInteractor
import com.ldev.newsfeed.feature.main_screen.domain.NewsInteractor
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class MainScreenViewModel(
    private val interactorNews: NewsInteractor,
    private val interactorBookmarks: BookmarksInteractor
) : BaseViewModel<ViewState>() {

    init {
        viewModelScope.launch {
            interactorBookmarks.subscribeByAddDateTime().asFlow().collect {
                processUiEvent(UiEvent.OnBookmarksFetched(articles = it))
            }
        }
        processUiEvent(UiEvent.GetNews)
    }

    override fun initialViewState(): ViewState {
        return ViewState(emptyList(), errorMessage = null, isLoading = true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.GetNews -> {
                interactorNews.getNews().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorNewsRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(it))
                    }
                )
            }
            is UiEvent.OnArticleClick -> {
                event.article
            }
            is UiEvent.OnBookmarkClick -> {
                if (event.article.isBookmarked) {
                    interactorBookmarks.delete(event.article)
                } else {
                    interactorBookmarks.create(
                        event.article.copy(
                            isBookmarked = true,
                            addBookmarkDateTime = Calendar.getInstance().timeInMillis
                        )
                    )
                }
            }
            is UiEvent.OnBookmarksFetched -> {
                val oldArticles = previousState.articles
                val newArticles = event.articles

                val articles = mapToList(oldList = oldArticles, newList = newArticles)
                return previousState.copy(articles = articles)
            }
            is DataEvent.SuccessNewsRequest -> {
                return previousState.copy(
                    articles = event.articleDomainModelList,
                    isLoading = false
                )
            }
            is DataEvent.ErrorNewsRequest -> {
                return previousState.copy(
                    isLoading = false,
                    errorMessage = event.errorMessage
                )
            }
        }
        return null
    }
}