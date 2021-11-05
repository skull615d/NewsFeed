package com.ldev.newsfeed.feature.web_screen

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentWebBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebScreenFragment : Fragment(R.layout.fragment_web) {
    companion object {
        const val KEY_URL = "keyUrl"
        fun newInstance(url: String) = WebScreenFragment().apply {
            arguments = bundleOf(Pair(KEY_URL, url))
        }
    }

    private val viewModel by viewModel<WebScreenViewModel>()

    private val binding by viewBinding(FragmentWebBinding::bind)

    private val url: String by lazy { requireArguments().getString(KEY_URL)!! }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        val web = view.findViewById<WebView>(R.id.webView)
        //web.settings.javaScriptEnabled = true
        web.webViewClient = WebViewClient()
        web.webChromeClient = ChromeClient()
        web.loadUrl(url)
    }

    fun render(viewState: ViewState) {
        binding.apply {
            progressBar.progress = viewState.progressLoading
        }
    }
}