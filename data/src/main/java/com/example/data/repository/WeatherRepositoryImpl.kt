package com.example.data.repository

import com.example.data.model.WeatherResponse
import com.example.data.network.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeather(): WeatherResponse = withContext(Dispatchers.IO) {
        api.getWeather()
    }
}