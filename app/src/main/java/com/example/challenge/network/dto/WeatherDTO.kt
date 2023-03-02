package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast,
    @SerializedName("location")
    val location: Location
)