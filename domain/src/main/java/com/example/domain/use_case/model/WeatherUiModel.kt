package com.example.domain.use_case.model

data class WeatherUiModel(
    val weather: List<WeatherUI>,
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Int,
    val humidity: Int,
    val speed: Double,
    val deg: Int,
    val name: String
)

data class WeatherUI(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
