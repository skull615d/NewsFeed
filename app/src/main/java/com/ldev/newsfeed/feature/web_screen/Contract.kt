package com.ldev.newsfeed.feature.web_screen

import com.ldev.newsfeed.base.Event

data class ViewState(
    val progressLoading: Int
)

sealed class UiEvent : Event

sealed class DataEvent : Event {
    data class SetProgress(val progressLoading: Int) : DataEvent()
}