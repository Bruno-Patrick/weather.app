package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class DailyDTO(
    @SerializedName("time") val time: List<String>,
    @SerializedName("weathercode") val weathercode: List<Int>
)