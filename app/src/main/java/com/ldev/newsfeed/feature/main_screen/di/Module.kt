package com.ldev.newsfeed.feature.main_screen.di

import com.ldev.newsfeed.feature.main_screen.MainScreenViewModel
import com.ldev.newsfeed.feature.main_screen.data.api.MainScreenApi
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org/"
val mainScreenModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }

    single<MainScreenApi> {
        get<Retrofit>().create(MainScreenApi::class.java)
    }

    viewModel {
        MainScreenViewModel()
    }
}