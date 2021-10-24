package com.ldev.newsfeed.feature.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ldev.newsfeed.R
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import com.ldev.newsfeed.utils.toStringFormat

class ArticlesAdapter(
    private var articles: List<ArticleDomainModel>,
    private val onBookmarkClick: (article: ArticleDomainModel) -> Unit,
    private val onArticleClick: (article: ArticleDomainModel) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = articles[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ViewHolder(itemViewMy: View) : RecyclerView.ViewHolder(itemViewMy) {
        private val title: TextView
        private val descriptions: TextView
        private val image: ImageView
        private val publishedAt: TextView
        private val buttonBookmark: ImageButton

        init {
            this.title = itemViewMy.findViewById(R.id.tvTitle)
            this.descriptions = itemViewMy.findViewById(R.id.tvDescription)
            this.image = itemViewMy.findViewById(R.id.ivArticleImage)
            this.publishedAt = itemViewMy.findViewById(R.id.tvPublishedAt)
            this.buttonBookmark = itemViewMy.findViewById(R.id.ibBookmark)
        }

        fun bind(item: ArticleDomainModel) {
            title.text = item.title
            descriptions.text = item.descriptions
            publishedAt.text = item.publishedAt?.let { it.toStringFormat() }
            if (item.isBookmarked) buttonBookmark.setImageResource(R.drawable.ic_bookmark_selected) else buttonBookmark.setImageResource(
                R.drawable.ic_bookmark
            )



            Glide.with(itemView)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_non_existing_url)
                .fallback(R.drawable.ic_placeholder)
                .into(image)

            buttonBookmark.setOnClickListener {
                onBookmarkClick(item)
            }
            itemView.setOnClickListener {
                onArticleClick(item)
            }
        }
    }

    fun updateArticles(newStates: List<ArticleDomainModel>) {
        articles = newStates
        notifyDataSetChanged()
    }
}
