package com.yongjae_project.shopping_app.data.local.dao

import androidx.room.*
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchHistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    @Delete
    suspend fun deleteSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    @Query("SELECT * FROM searchHistory ORDER BY searchAt DESC LIMIT 20")
    fun getSearchHistory() : Flow<List<SearchHistoryItem>>

}