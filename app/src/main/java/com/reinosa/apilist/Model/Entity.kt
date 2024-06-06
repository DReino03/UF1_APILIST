package com.reinosa.apilist.Model

import androidx.room.Entity

@Entity (tableName = "news_table") // This is the name of the table in the database
data class news_tablename(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) {
    data class Source(
        val id: Any?,
        val name: String
    )
}