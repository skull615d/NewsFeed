package com.ldev.newsfeed.feature.bookmarks_screen.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentBookmarksBinding
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import com.ldev.newsfeed.feature.web_screen.WebScreenFragment
import com.ldev.newsfeed.utils.setGoneBottomNavBar
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksScreenFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel by viewModel<BookmarksViewModel>()
    private val binding: FragmentBookmarksBinding by viewBinding(FragmentBookmarksBinding::bind)
    private val articlesAdapter = ArticlesAdapter(
        onBookmarkClick = { viewModel.processUiEvent(UiEvent.OnBookmarkClick(it)) },
        onArticleClick = {
            findNavController().navigate(
                R.id.action_bookmarksScreenFragment_to_webScreenFragment,
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
        super.onViewCreated(view, savedInstanceState)
        setGoneBottomNavBar(false)
        binding.rvBookmarks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = articlesAdapter
        }
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun render(viewState: ViewState) {
        articlesAdapter.items = viewState.articles
    }
}