package com.ldev.newsfeed

import android.app.Application
import com.ldev.newsfeed.di.appModule
import com.ldev.newsfeed.di.dataBaseModule
import com.ldev.newsfeed.feature.bookmarks_screen.di.bookmarksScreenModule
import com.ldev.newsfeed.feature.main_screen.di.mainScreenModule
import com.ldev.newsfeed.feature.web_screen.di.webScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin {
            //androidLogger()
            androidContext(this@App)
            modules(
                appModule,
                mainScreenModule,
                dataBaseModule,
                bookmarksScreenModule,
                webScreenModule
            )
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // shutdown Timber
        }
    }
}