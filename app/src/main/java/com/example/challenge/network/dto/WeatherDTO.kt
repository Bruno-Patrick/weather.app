package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class WeatherDTO(
    @SerializedName("daily") val daily: DailyDTO,
//    @SerializedName("daily_units") val dailyUnits: DailyUnitsDTO,
//    @SerializedName("elevation") val elevation: Double,
//    @SerializedName("generationtime_ms") val generationtimeMs: Double,
    @SerializedName("hourly") val hourly: HourlyDTO,
//    @SerializedName("hourly_units") val hourlyUnitsDTO: HourlyUnitsDTO,
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("timezone") val timezone: String,
//    @SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
//    @SerializedName("utc_offset_seconds") val utcOffsetSeconds: Int
)