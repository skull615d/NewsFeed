package com.ldev.newsfeed

import android.app.Application
import com.ldev.newsfeed.di.appModule
import com.ldev.newsfeed.feature.main_screen.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(appModule, mainScreenModule))
        }
    }
}