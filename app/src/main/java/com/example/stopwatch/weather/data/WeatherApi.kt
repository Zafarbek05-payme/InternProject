package com.example.stopwatch.weather.data

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("lat") lat: Double = 41.3123363,
        @Query("lon") lon: Double = 69.2787079,

        @Query("appid") apiKey: String = "e72aa87d6bcb6920e06f3f94eb5bc0db",
        @Query("units") units: String = "metric"
    ): WeatherResponse
}