package com.example.data.repository

import com.example.data.model.NewsResponse
import com.example.data.network.NewsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsRepository {
    override suspend fun getNews(): NewsResponse = withContext(Dispatchers.IO) {
        api.getNews()
    }
}