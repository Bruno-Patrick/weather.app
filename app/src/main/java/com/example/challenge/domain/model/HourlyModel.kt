package com.example.challenge.domain.model


data class HourlyModel(
    val pressureMsl: List<Double>,
    val relativehumidity2m: List<Int>,
    val temperature2m: List<Double>,
    val time: List<String>,
    val windspeed10m: List<Double>
)