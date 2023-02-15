package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class HourlyDTO(
    @SerializedName("pressure_msl") val pressureMsl: List<Double>,
    @SerializedName("relativehumidity_2m") val relativehumidity2m: List<Int>,
    @SerializedName("temperature_2m") val temperature2m: List<Double>,
    @SerializedName("time") val time: List<String>,
    @SerializedName("windspeed_10m") val windspeed10m: List<Double>
)