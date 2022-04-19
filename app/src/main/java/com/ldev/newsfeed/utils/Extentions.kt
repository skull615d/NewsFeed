package com.ldev.newsfeed.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.ldev.newsfeed.R
import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import java.text.SimpleDateFormat
import java.util.*

fun String.toCalendar(dateFormat: String = "yyyy-MM-dd'T'HH:mm:ss"): Calendar? {
    val calendar = Calendar.getInstance()
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.parse(this)?.let { calendar.time = it }
    if (calendar == Calendar.getInstance()) return null
    return calendar
}

fun Calendar.toStringFormat(format: String = "dd.MM.yyyy HH:mm"): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    return formatter.format(this.time)
}

fun List<ArticleDomainModel>.lastTime(hour: Int = 1): List<ArticleDomainModel> {
    val delay = hour * 60 * 60 * 1000
    this.filter { article ->
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = calendar.timeInMillis.minus(delay)
        article.publishedAt?.let { it > calendar } ?: false
    }
    return this
}

fun Fragment.setGoneBottomNavBar(isGone: Boolean) {
    val actions by lazy { requireActivity() as MainActivityActions }
    actions.setGoneBottomNavBar(isGone)
}

fun ImageView.loadImage(
    src: String?,
    @DrawableRes errorRes: Int = R.drawable.ic_placeholder,
    @DrawableRes placeholderRes: Int = R.drawable.ic_placeholder,
    config: RequestBuilder<Drawable>.() -> Unit = {}
) {
    Glide
        .with(context)
        .load(src)
        .error(errorRes)
        .placeholder(placeholderRes)
        .apply { config(this) }
        .into(this)
}

