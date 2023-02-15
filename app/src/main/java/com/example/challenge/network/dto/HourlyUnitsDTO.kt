package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class HourlyUnitsDTO(
    @SerializedName("pressure_msl") val pressureMsl: String,
    @SerializedName("relativehumidity_2m") val relativehumidity2m: String,
    @SerializedName("temperature_2m") val temperature2m: String,
    @SerializedName("time") val time: String,
    @SerializedName("windspeed_10m") val windspeed10m: String
)