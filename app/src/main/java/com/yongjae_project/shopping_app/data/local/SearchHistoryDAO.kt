package com.yongjae_project.shopping_app.data.local

import androidx.room.*
import com.yongjae_project.shopping_app.data.model.SearchHistoryItem

@Dao
interface SearchHistoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    @Delete
    suspend fun deleteSearchHistoryItem(searchHistoryItem: SearchHistoryItem)

    @Query("SELECT * FROM searchHistory ORDER BY searchAt ASC LIMIT 20")
    suspend fun getSearchHistory() : List<SearchHistoryItem>

}