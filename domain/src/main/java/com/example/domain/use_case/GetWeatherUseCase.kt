package com.example.domain.use_case

import com.example.data.model.WeatherResponse
import com.example.data.repository.WeatherRepository
import com.example.domain.use_case.mapper.mapper
import com.example.domain.use_case.model.WeatherUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(private val repository: WeatherRepository) {
    suspend fun getWeather(): WeatherUiModel = withContext(Dispatchers.IO) {
        mapper(repository.getWeather())
    }
}