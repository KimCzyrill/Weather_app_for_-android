package com.example.weather_app

data class WeatherResponse(
    val main: Main,
    val wind: Wind,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Wind(
    val speed: Double
)

data class Weather(
    val description: String
)