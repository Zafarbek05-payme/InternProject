package com.example.miniapps.weather

//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData by viewModel.weatherData
    val isLoading by viewModel.isLoading
    val error by viewModel.error

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (error != null) {
            Text(text = "Error fetching weather: $error")
        } else if (weatherData != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Tashkent", fontSize = 20.sp)
                Text(text = "${weatherData?.main?.temp}°C", fontSize = 32.sp)
                Text(text = "Feels like ${weatherData?.main?.feelsLike}°C")
                Text(text = "Description: ${weatherData?.weather?.get(0)?.description}")
                Text(text = "Wind: ${weatherData?.wind?.speed} m/s")
                Text(text = "Humidity: ${weatherData?.main?.humidity}%")
            }
        } else {
            Text(text = "No weather data available.")
        }
    }
}