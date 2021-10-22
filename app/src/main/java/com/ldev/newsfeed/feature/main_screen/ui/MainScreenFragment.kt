package com.ldev.newsfeed.feature.main_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ldev.newsfeed.R
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {

    private val viewModel by viewModel<MainScreenViewModel>()
    lateinit var progressBarArticles: ProgressBar
    lateinit var textViewError: TextView

    private val adapter by lazy {
        ArticlesAdapter(listOf())
        { article ->
            viewModel.processUiEvent(UiEvent.OnArticleClick(article))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_mainscreen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerViewArticles: RecyclerView = view.findViewById(R.id.rvArticles)
        progressBarArticles = view.findViewById(R.id.pbArticles)
        textViewError = view.findViewById(R.id.tvError)
        recyclerViewArticles.adapter = adapter
        recyclerViewArticles.layoutManager = LinearLayoutManager(requireContext())

        viewModel.viewState.observe(viewLifecycleOwner, Observer(::render))

    }

    private fun render(viewState: ViewState) {
        updateProgressBar(viewState)
        updateErrorText(viewState)
        updateList(viewState)
    }

    private fun updateErrorText(viewState: ViewState) {
        textViewError.text = viewState.errorMessage
        textViewError.isVisible = viewState.isInErrorState
    }

    private fun updateProgressBar(viewState: ViewState) {
        progressBarArticles.isVisible = viewState.isLoading
    }

    private fun updateList(viewState: ViewState) {
        adapter.updateArticles(viewState.articles)
    }
}
