package com.ldev.newsfeed.feature.main_screen.di

import com.ldev.newsfeed.feature.main_screen.MainScreenViewModel
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenApi
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRemoteSource
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepo
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenRepoImpl
import com.ldev.newsfeed.feature.main_screen.data.api.model.MainScreenSourceModel
import com.ldev.newsfeed.feature.main_screen.domain.NewsInteractor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val mainScreenModule = module {

    single<MainScreenApi> {
        get<Retrofit>().create(MainScreenApi::class.java)
    }

    viewModel {
        MainScreenViewModel()
    }

    single<MainScreenRemoteSource> {
        MainScreenRemoteSource(get<MainScreenApi>())
    }

    single<MainScreenRepo>{
        MainScreenRepoImpl(get<MainScreenRemoteSource>())
    }
    
    single<NewsInteractor>{
        NewsInteractor(get<MainScreenRepo>())
    }
}