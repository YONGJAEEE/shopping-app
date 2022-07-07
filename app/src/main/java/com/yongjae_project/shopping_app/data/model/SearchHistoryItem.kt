package com.yongjae_project.shopping_app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "searchHistory")

data class SearchHistoryItem(
    @PrimaryKey val searchText: String,
    val searchAt: String,
):Serializable
