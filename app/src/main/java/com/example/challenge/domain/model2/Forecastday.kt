package com.example.challenge.domain.model2



data class Forecastday(
    var date: String,
    var day: Day,
    var hour: List<Hour>
//    val astro: Astro,
//    val dateEpoch: Int,
)