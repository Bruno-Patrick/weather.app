package com.example.challenge.network.dto2


import com.google.gson.annotations.SerializedName

data class Weather2DTO(
    @SerializedName("current")
    val current: Current,
    @SerializedName("forecast")
    val forecast: Forecast,
    @SerializedName("location")
    val location: Location
)