package com.example.challenge.domain.model


data class WeatherModel(
    var current: Current,
    var forecast: Forecast,
    var location: Location
)