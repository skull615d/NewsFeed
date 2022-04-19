package com.ldev.newsfeed.feature.main_screen.ui.adapter

import android.content.Intent
import androidx.core.view.isGone
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.ItemArticleBinding
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.utils.loadImage
import com.ldev.newsfeed.utils.toStringFormat

fun articleDelegate(
    onBookmarkClick: (ArticleDomainModel) -> Unit,
    onArticleClick: (ArticleDomainModel) -> Unit
) =
    adapterDelegateViewBinding<ArticleDomainModel, ArticleDomainModel, ItemArticleBinding>(
        { layoutInflater, parent -> ItemArticleBinding.inflate(layoutInflater, parent, false) }
    ) {
        bind {
            binding.apply {
                tvTitle.text = item.title
                tvDescription.text = item.descriptions
                tvPublishedAt.text = item.publishedAt?.let { it.toStringFormat() }
                if (item.isBookmarked) {
                    ibBookmark.setImageResource(R.drawable.ic_bookmark_selected)
                } else {
                    ibBookmark.setImageResource(R.drawable.ic_bookmark)
                }

                ivArticleImage.loadImage(item.urlToImage)
                ivArticleImage.isGone = item.urlToImage == ""

                ibBookmark.setOnClickListener {
                    onBookmarkClick(item)
                }

                ibShare.setOnClickListener {
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        putExtra(Intent.EXTRA_TEXT, item.url)
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(intent, null))
                }

                root.setOnClickListener {
                    onArticleClick(item)
                }
            }
        }
    }