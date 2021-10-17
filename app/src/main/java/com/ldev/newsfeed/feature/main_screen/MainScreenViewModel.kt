package com.ldev.newsfeed.feature.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ldev.newsfeed.feature.main_screen.domain.NewsInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: NewsInteractor): ViewModel() {
    var TAG = "ViewModel"
    fun requestNews(){
        viewModelScope.launch {
            val list = interactor.getNews()
            Log.d(TAG, list.toString())
        }
    }
}