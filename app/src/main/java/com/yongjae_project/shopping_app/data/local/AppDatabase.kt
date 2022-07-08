package com.yongjae_project.shopping_app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yongjae_project.shopping_app.data.local.dao.SearchHistoryDAO
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem

@Database(
    entities = [SearchHistoryItem::class],
    version = 1,
    exportSchema = false,
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDAO
}