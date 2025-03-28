package com.example.miniapps.navigation

sealed class Screens (
    val screen: String
){
    data object Weather: Screens("weather")
    data object Stopwatch: Screens("stopwatch")
    data object News: Screens("news")
}