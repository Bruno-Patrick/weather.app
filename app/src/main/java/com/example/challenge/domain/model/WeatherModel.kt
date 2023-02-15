package com.example.challenge.domain.model

import com.example.challenge.network.dto.DailyDTO
import com.example.challenge.network.dto.DailyUnitsDTO
import com.example.challenge.network.dto.HourlyDTO
import com.example.challenge.network.dto.HourlyUnitsDTO


data class WeatherModel(
    val daily: DailyDTO,
    val dailyUnits: DailyUnitsDTO,
    val elevation: Double,
    val generationtimeMs: Double,
    val hourlyDTO: HourlyDTO,
    val hourlyUnitsDTO: HourlyUnitsDTO,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezoneAbbreviation: String,
    val utcOffsetSeconds: Int
)
