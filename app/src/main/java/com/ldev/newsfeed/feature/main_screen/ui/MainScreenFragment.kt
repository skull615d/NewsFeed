package com.ldev.newsfeed.feature.main_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentMainscreenBinding
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(R.layout.fragment_mainscreen) {

    private val viewModel by viewModel<MainScreenViewModel>()
    private val binding: FragmentMainscreenBinding by viewBinding(FragmentMainscreenBinding::bind)

    private val adapterArticles: ArticlesAdapter by lazy {
        ArticlesAdapter(
            articles = listOf(),
            onBookmarkClick = { viewModel.processUiEvent(UiEvent.OnBookmarkClick(it)) },
            onArticleClick = { viewModel.processUiEvent(UiEvent.OnArticleClick(it)) }
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.rvArticles.apply {
            adapter = adapterArticles
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

    }

    private fun render(viewState: ViewState) {
        updateProgressBar(viewState)
        updateErrorText(viewState)
        updateList(viewState)
    }

    private fun updateErrorText(viewState: ViewState) {
        binding.tvError.apply {
            text = viewState.errorMessage
            isVisible = viewState.isInErrorState
        }
    }

    private fun updateProgressBar(viewState: ViewState) {
        binding.pbArticles.isVisible = viewState.isLoading
    }

    private fun updateList(viewState: ViewState) {
        adapterArticles.updateArticles(viewState.articles)
    }
}
