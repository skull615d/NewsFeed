package com.ldev.newsfeed.feature.main_screen.ui

import com.ldev.newsfeed.base.BaseViewModel
import com.ldev.newsfeed.base.Event
import com.ldev.newsfeed.feature.main_screen.domain.NewsInteractor

class MainScreenViewModel(private val interactor: NewsInteractor) : BaseViewModel<ViewState>() {

    init {
        processUiEvent(UiEvent.GetCurrentNews)
    }

    override fun initialViewState(): ViewState {
        return ViewState(emptyList(), errorMessage = null, isLoading = true)
    }

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.GetCurrentNews -> {
                interactor.getNews().fold(
                    onError = {
                        processDataEvent(DataEvent.ErrorNewsRequest(it.localizedMessage ?: ""))
                    },
                    onSuccess = {
                        processDataEvent(DataEvent.SuccessNewsRequest(it))
                    }
                )
            }
            is DataEvent.OnLoadData -> {

            }
            is UiEvent.OnArticleClick -> {

            }
            is UiEvent.OnBookmarkClick -> {

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