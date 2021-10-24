package com.ldev.newsfeed.utils

import com.ldev.newsfeed.feature.main_screen.domain.model.ArticleDomainModel
import java.text.SimpleDateFormat
import java.util.*

fun String.toCalendar(dataFormat: String = "yyyy-MM-dd'T'HH:mm:ss"): Calendar? {
    val calendar = Calendar.getInstance()
    val parser = SimpleDateFormat(dataFormat, Locale.getDefault())
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
    lateinit var calendar: Calendar
    this.filter { article ->
        calendar = Calendar.getInstance()
        calendar.timeInMillis = calendar.timeInMillis.minus(delay)
        article.publishedAt?.let { it > calendar } ?: false
    }
    return this
}