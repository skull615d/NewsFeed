package com.ldev.newsfeed.feature.bookmarks_screen.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = BookmarksEntity.TABLE_NAME)
data class BookmarksEntity(
    @PrimaryKey
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "author")
    val author: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "descriptions")
    val descriptions: String,
    @ColumnInfo(name = "urlToImage")
    val urlToImage: String,
    @ColumnInfo(name = "publishedAt")
    val publishedAt: String,
    @ColumnInfo(name = "isBookmarked")
    val isBookmarked: Boolean,
    @ColumnInfo(name = "addBookmarkDateTime")
    val addBookmarkDateTime: Long// in timemillis
) {
    companion object {
        const val TABLE_NAME = "BOOKMARKS_TABLE"
    }
}