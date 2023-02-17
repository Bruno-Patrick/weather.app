package com.example.challenge.domain.model


data class HourlyUnitsModel(
    var pressureMsl: String,
    var relativehumidity2m: String,
    var temperature2m: String,
    var time: String,
    var windspeed10m: String
)