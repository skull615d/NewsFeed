package com.ldev.newsfeed.feature.web_screen

import com.ldev.newsfeed.base.BaseViewModel
import com.ldev.newsfeed.base.Event

class WebScreenViewModel : BaseViewModel<ViewState>() {
    override fun initialViewState() = ViewState(0)

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.SetProgress -> {
                previousState.copy(progressLoading = event.progressLoading)
            }
        }
        return null
    }

    fun setProgress(progress: Int) {
        processDataEvent(DataEvent.SetProgress(progress))
    }
}