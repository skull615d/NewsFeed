package com.ldev.newsfeed.feature.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.ItemArticleBinding
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.utils.loadImage
import com.ldev.newsfeed.utils.toStringFormat

class ArticlesAdapter(
    private var articles: List<ArticleDomainModel>,
    private val onBookmarkClick: (article: ArticleDomainModel) -> Unit,
    private val onArticleClick: (article: ArticleDomainModel) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemArticleBinding =
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = articles[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ArticleDomainModel) {
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

                ibBookmark.setOnClickListener {
                    onBookmarkClick(item)
                }

                root.setOnClickListener {
                    onArticleClick(item)
                }
            }
        }
    }

    fun updateArticles(newStates: List<ArticleDomainModel>) {
        articles = newStates
        notifyDataSetChanged()
    }
}
