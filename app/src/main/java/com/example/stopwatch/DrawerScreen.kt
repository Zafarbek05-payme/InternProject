package com.example.stopwatch

sealed class DrawerScreen(val path: String, val title: String){
    object Weather: DrawerScreen("weather", "Weather")
    object Stopwatch: DrawerScreen("stopwatch", "Stopwatch")
}

val drawerScreen = listOf(DrawerScreen.Weather, DrawerScreen.Stopwatch)