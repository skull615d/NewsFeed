package com.ldev.newsfeed.feature.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ldev.newsfeed.R
import com.ldev.newsfeed.databinding.ItemArticleBinding
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
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

                Glide.with(binding.root)
                    .load(item.urlToImage)
                    .centerCrop()
                    .placeholder(R.drawable.ic_placeholder)
                    .error(R.drawable.ic_non_existing_url)
                    .fallback(R.drawable.ic_placeholder)
                    .into(ivArticleImage)

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
