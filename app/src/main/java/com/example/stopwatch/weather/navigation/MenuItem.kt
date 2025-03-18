package com.example.stopwatch.weather.navigation

sealed class MenuItem(val title: String, val route: String) {
    object Stopwatch : MenuItem("Stopwatch", "stopwatch")
    object Weather : MenuItem("Weather", "weather")
    object Settings : MenuItem("Settings", "settings")
}

val menuItems = listOf(
    MenuItem.Stopwatch, MenuItem.Weather, MenuItem.Settings
)