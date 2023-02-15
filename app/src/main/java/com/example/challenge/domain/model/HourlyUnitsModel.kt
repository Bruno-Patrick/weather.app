package com.example.challenge.domain.model


data class HourlyUnitsModel(
    val pressureMsl: String,
    val relativehumidity2m: String,
    val temperature2m: String,
    val time: String,
    val windspeed10m: String
)