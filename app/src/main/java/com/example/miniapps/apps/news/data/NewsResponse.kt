package com.example.miniapps.apps.news.data

import androidx.compose.runtime.Stable

@Stable
data class NewsResponse(
    val newsList: List<Article>
)

data class Article(
    val source: String,
    val author: String
)