package com.example.data.repository

import com.example.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(): WeatherResponse
}