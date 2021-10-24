package com.ldev.newsfeed.feature.bookmarks_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ldev.newsfeed.R
import com.ldev.newsfeed.feature.main_screen.ui.adapter.ArticlesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookmarksScreenFragment : Fragment() {

    private val viewModel by viewModel<BookmarksViewModel>()
    private val articlesAdapter: ArticlesAdapter by lazy {
        ArticlesAdapter(
            articles = emptyList(),
            onBookmarkClick = { viewModel.processUiEvent(UiEvent.OnBookmarkClick(it)) },
            onArticleClick = { viewModel.processUiEvent(UiEvent.OnArticleClick(it)) }
        )
    }

    companion object {
        fun newInstance(): BookmarksScreenFragment = BookmarksScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmarks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.rvBookmarks)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = articlesAdapter

        viewModel.viewState.observe(viewLifecycleOwner, ::render)
    }

    private fun render(viewState: ViewState) {
        val articles = viewState.articles
        articlesAdapter.updateArticles(articles)
    }
}