package com.ldev.newsfeed.feature.web_screen

import android.webkit.WebChromeClient
import android.webkit.WebView


class ChromeClient : WebChromeClient() {
    companion object {
        var progress: Int = 0
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)

    }
}