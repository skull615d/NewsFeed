package com.ldev.newsfeed.feature.web_screen

import android.webkit.WebChromeClient
import android.webkit.WebView


class ChromeClient(private val getProgress: (Int) -> Unit) : WebChromeClient() {

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        getProgress(newProgress)
    }
}