package com.ldev.newsfeed.di

import androidx.room.Room
import com.ldev.newsfeed.AppDataBase
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org/"
const val DATA_BASE = "DATA_BASE"
val appModule = module {
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
}
val dataBaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDataBase::class.java, DATA_BASE)
            .fallbackToDestructiveMigration()// удаляет все таблицы, в продакшен делать не стоит
            .build()
    }

    single {
        get<AppDataBase>().getBookmarksDAO()
    }
}