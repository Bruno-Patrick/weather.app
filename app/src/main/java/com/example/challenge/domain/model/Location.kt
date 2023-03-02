package com.example.challenge.domain.model


data class Location(
    var country: String,
    var lat: Double,
//    val localtime: String,
//    val localtimeEpoch: Int,
    var lon: Double,
    var name: String,
    var region: String,
//    val tzId: String
)