package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class DailyUnitsDTO(
    @SerializedName("time") val time: String,
    @SerializedName("weathercode") val weathercode: String
)