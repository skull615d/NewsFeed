package com.ldev.newsfeed.feature.web_screen.di

import com.ldev.newsfeed.feature.web_screen.WebScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val webScreenModule = module {
    viewModel {
        WebScreenViewModel()
    }
}