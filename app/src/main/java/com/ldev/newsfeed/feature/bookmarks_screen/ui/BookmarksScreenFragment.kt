package com.ldev.newsfeed.feature.bookmarks_screen.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.FragmentBookmarksBinding
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import com.ldev.newsfeed.feature.web_screen.WebScreenFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksScreenFragment : Fragment(R.layout.fragment_bookmarks) {

    private val viewModel by viewModel<BookmarksViewModel>()
    private val binding: FragmentBookmarksBinding by viewBinding(FragmentBookmarksBinding::bind)
    private val articlesAdapter: ArticlesAdapter by lazy {
        ArticlesAdapter(
            articles = emptyList(),
            onBookmarkClick = { viewModel.processUiEvent(UiEvent.OnBookmarkClick(it)) },
            onArticleClick = { setFragment(WebScreenFragment.newInstance(it.url)) }
        )
    }

    companion object {
        fun newInstance(): BookmarksScreenFragment = BookmarksScreenFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBookmarks.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = articlesAdapter
        }
        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun render(viewState: ViewState) {
        articlesAdapter.updateArticles(viewState.articles)
    }

    private fun setFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .add(android.R.id.content, fragment)
            .addToBackStack("bookmarks")
            .commit()
    }
}