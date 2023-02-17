package com.example.challenge.domain.model

import com.example.challenge.network.dto.DailyDTO
import com.example.challenge.network.dto.DailyUnitsDTO
import com.example.challenge.network.dto.HourlyDTO
import com.example.challenge.network.dto.HourlyUnitsDTO


data class WeatherModel(
    var daily: DailyDTO,
//    var dailyUnits: DailyUnitsDTO,
//    var elevation: Double,
//    var generationtimeMs: Double,
    var hourly: HourlyDTO,
//    var hourlyUnitsDTO: HourlyUnitsDTO,
    var latitude: Double,
    var longitude: Double,
    var timezone: String,
//    var timezoneAbbreviation: String,
//    var utcOffsetSeconds: Int
)
