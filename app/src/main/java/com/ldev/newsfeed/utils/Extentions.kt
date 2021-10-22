package com.ldev.newsfeed.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.toCalendar(dataFormat: String): Calendar? {
    val calendar = Calendar.getInstance()
    val parser = SimpleDateFormat(dataFormat, Locale.getDefault())
    parser.parse(this)?.let { calendar.time = it }
    if (calendar == Calendar.getInstance()) return null
    return calendar
}