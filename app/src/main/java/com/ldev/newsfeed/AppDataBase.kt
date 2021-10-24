package com.ldev.newsfeed

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ldev.newsfeed.feature.bookmarks_screen.data.local.BookmarksDAO
import com.ldev.newsfeed.feature.bookmarks_screen.data.local.BookmarksEntity

@Database(entities = [BookmarksEntity::class], version = 4)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getBookmarksDAO(): BookmarksDAO
}