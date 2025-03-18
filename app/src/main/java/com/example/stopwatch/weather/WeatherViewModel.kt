package com.example.stopwatch.weather

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stopwatch.weather.data.RetrofitInstance
import com.example.stopwatch.weather.data.WeatherResponse
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weatherData = mutableStateOf<WeatherResponse?>(null)
    val weatherData: State<WeatherResponse?> = _weatherData

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _error = mutableStateOf<String?>(null)
    val error: State<String?> = _error

    init {
        fetchData()
    }

    private fun fetchData(){
        viewModelScope.launch {
            _isLoading.value = true
            _error.value = null

            try {
                val response = RetrofitInstance.api.getWeather()
                _weatherData.value = response
            } catch (e: Exception){
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}