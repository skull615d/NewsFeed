package com.ldev.newsfeed.feature.main_screen.di

import com.ldev.newsfeed.feature.bookmarks_screen.data.BookmarksRepo
import com.ldev.newsfeed.feature.bookmarks_screen.domain.BookmarksInteractor
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenApi
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRemoteSource
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepoImpl
import com.ldev.newsfeed.feature.main_screen.domain.NewsInteractor
import com.ldev.newsfeed.feature.main_screen.ui.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val mainScreenModule = module {

    single<MainScreenApi> {
        get<Retrofit>().create(MainScreenApi::class.java)
    }

    single<MainScreenRemoteSource> {
        MainScreenRemoteSource(get<MainScreenApi>())
    }

    single<MainScreenRepo>{
        MainScreenRepoImpl(get<MainScreenRemoteSource>())
    }

    single<NewsInteractor>{
        NewsInteractor(get<MainScreenRepo>(), get<BookmarksRepo>())
    }

    viewModel {
        MainScreenViewModel(get<NewsInteractor>(), get<BookmarksInteractor>())
    }
}