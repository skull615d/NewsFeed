package com.ldev.newsfeed.feature.bookmarks_screen.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BookmarksDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(entity: BookmarksEntity)

    @Query("SELECT * FROM ${BookmarksEntity.TABLE_NAME}")
    suspend fun read(): List<BookmarksEntity>

    @Query("SELECT * FROM ${BookmarksEntity.TABLE_NAME} ORDER BY addBookmarkDateTime DESC")
    fun subscribeByAddDateTime(): LiveData<List<BookmarksEntity>>

    @Update
    suspend fun update(entity: BookmarksEntity)

    @Delete
    suspend fun delete(entity: BookmarksEntity)
}