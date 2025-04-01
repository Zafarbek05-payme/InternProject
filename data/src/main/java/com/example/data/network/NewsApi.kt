package com.example.data.network

import com.example.data.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("newsapi.org/v2/everything")
    suspend fun getNews(
        @Query("q") query: String = "science",
        @Query("apiKey") apiKey : String = "b79fd40ae4b4430296e307234f07d24a"
    ) : NewsResponse
}