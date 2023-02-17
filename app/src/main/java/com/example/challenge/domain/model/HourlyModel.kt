package com.example.challenge.domain.model


data class HourlyModel(
    var pressureMsl: List<Double>,
    var relativehumidity2m: List<Int>,
    var temperature2m: List<Double>,
    var time: List<String>,
    var windspeed10m: List<Double>
)