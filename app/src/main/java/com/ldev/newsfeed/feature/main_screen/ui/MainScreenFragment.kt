package com.ldev.newsfeed.feature.main_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentMainscreenBinding
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import com.ldev.newsfeed.feature.web_screen.WebScreenFragment
import com.ldev.newsfeed.utils.setGoneBottomNavBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(R.layout.fragment_mainscreen) {

    private val viewModel by viewModel<MainScreenViewModel>()
    private val binding: FragmentMainscreenBinding by viewBinding(FragmentMainscreenBinding::bind)
    private val articlesAdapter = ArticlesAdapter(
        onBookmarkClick = { viewModel.processUiEvent(UiEvent.OnBookmarkClick(it)) },
        onArticleClick = {
            findNavController().navigate(
                R.id.action_mainScreenFragment_to_webScreenFragment,
                bundleOf(WebScreenFragment.KEY_URL to it.url),
                navOptions {
                    this.anim {
                        enter = R.anim.nav_default_enter_anim
                        popEnter = R.anim.nav_default_pop_enter_anim
                        popExit = R.anim.nav_default_pop_exit_anim
                        exit = R.anim.nav_default_exit_anim
                    }
                }
            )
        }
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setGoneBottomNavBar(false)
        binding.rvArticles.apply {
            adapter = articlesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.srlArticles.setOnRefreshListener {
            viewModel.processUiEvent(UiEvent.GetNews)
        }

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun render(viewState: ViewState) {
        updateErrorText(viewState)
        articlesAdapter.items = viewState.articles
        binding.srlArticles.isRefreshing = viewState.isLoading
    }

    private fun updateErrorText(viewState: ViewState) {
        viewState.errorMessage?.let {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        }
    }
}
