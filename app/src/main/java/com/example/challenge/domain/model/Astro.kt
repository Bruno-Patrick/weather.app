package com.example.challenge.domain.model



data class Astro(
    val isMoonUp: Int,
    val isSunUp: Int,
    val moonIllumination: String,
    val moonPhase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)