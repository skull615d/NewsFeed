package com.ldev.newsfeed.feature.web_screen

import com.ldev.newsfeed.base.Event

data class ViewState(
    val progressLoading: Int
)

sealed class UiEvent : Event {
    data class SetProgress(val progressLoading: Int) : UiEvent()
}