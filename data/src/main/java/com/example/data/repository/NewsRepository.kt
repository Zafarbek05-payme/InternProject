package com.example.data.repository

import com.example.data.model.NewsResponse

interface NewsRepository {
    suspend fun getNews(): NewsResponse
}