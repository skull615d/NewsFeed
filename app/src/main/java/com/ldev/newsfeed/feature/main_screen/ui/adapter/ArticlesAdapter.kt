package com.ldev.newsfeed.feature.main_screen.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel

class ArticlesAdapter(
    onBookmarkClick: (ArticleDomainModel) -> Unit,
    onArticleClick: (ArticleDomainModel) -> Unit,
) :
    AsyncListDifferDelegationAdapter<ArticleDomainModel>(DIFF_UTIL) {
    init {
        delegatesManager.addDelegate(
            articleDelegate(
                onBookmarkClick = { onBookmarkClick(it) },
                onArticleClick = { onArticleClick(it) }
            )
        )
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<ArticleDomainModel>() {
            override fun areItemsTheSame(
                oldItem: ArticleDomainModel,
                newItem: ArticleDomainModel
            ) = oldItem.url == newItem.url

            override fun areContentsTheSame(
                oldItem: ArticleDomainModel,
                newItem: ArticleDomainModel
            ) = oldItem.isBookmarked == newItem.isBookmarked
        }
    }
}