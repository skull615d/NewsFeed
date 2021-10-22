package com.ldev.newsfeed.feature.main_screen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ldev.newsfeed.R
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import java.text.SimpleDateFormat

class ArticlesAdapter(
    private var states: List<ArticleDomainModel>,
    private val onItemClick: (article: ArticleDomainModel) -> Unit
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {


    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val title: TextView
        val descriptions: TextView
        val image: ImageView
        val publishedAt: TextView

        init {
            this.title = v.findViewById<TextView>(R.id.tvTitle)
            this.descriptions = v.findViewById<TextView>(R.id.tvDescription)
            this.image = v.findViewById(R.id.ivArticleImage)
            this.publishedAt = v.findViewById(R.id.tvPublishedAt)
        }

        fun bind(item: ArticleDomainModel) {
            title.text = item.title
            descriptions.text = item.descriptions
            val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
            publishedAt.text = item.publishedAt?.let { formatter.format(it.time) }

            Glide.with(itemView)
                .load(item.urlToImage)
                .centerCrop()
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_non_existing_url)
                .fallback(R.drawable.ic_placeholder)
                .into(image)

            itemView.setOnClickListener {
                // onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(states[position])

    }

    override fun getItemCount(): Int {
        return states.size
    }

    fun updateArticles(newStates: List<ArticleDomainModel>) {
        states = newStates
        notifyDataSetChanged()
    }
}
