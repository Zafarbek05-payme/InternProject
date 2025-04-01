package com.example.domain.use_case.mapper

import com.example.data.model.WeatherResponse
import com.example.domain.use_case.model.WeatherUI
import com.example.domain.use_case.model.WeatherUiModel

fun mapper(response: WeatherResponse): WeatherUiModel {
    return WeatherUiModel(
        weather = response.weather.map { weather ->
            WeatherUI(
                id = weather.id,
                main = weather.main,
                description = weather.description,
                icon = weather.icon
            )
        },
        temp = response.main.temp,
        feelsLike = response.main.feelsLike,
        tempMin = response.main.tempMin,
        tempMax = response.main.tempMax,
        pressure = response.main.pressure,
        humidity = response.main.humidity,
        speed = response.wind.speed,
        deg = response.wind.deg,
        name = response.name
    )
}