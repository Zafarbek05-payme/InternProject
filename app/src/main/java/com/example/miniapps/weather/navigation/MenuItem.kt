package com.example.miniapps.weather.navigation

sealed class MenuItem(val title: String, val route: String) {
    object Stopwatch : MenuItem("Stopwatch", "stopwatch")
    object Weather : MenuItem("Weather", "weather")
}

val menuItems = listOf(
    MenuItem.Stopwatch, MenuItem.Weather
)