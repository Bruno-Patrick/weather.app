package com.example.challenge.network.dto


import com.google.gson.annotations.SerializedName

data class Day(
//    @SerializedName("avghumidity")
//    val avghumidity: Double,
    @SerializedName("avgtemp_c")
    val avgtemp_c: Float,
//    @SerializedName("avgtemp_f")
//    val avgtempF: Double,
//    @SerializedName("avgvis_km")
//    val avgvisKm: Double,
//    @SerializedName("avgvis_miles")
//    val avgvisMiles: Double,
    @SerializedName("condition")
    val condition: Condition,
//    @SerializedName("daily_chance_of_rain")
//    val dailyChanceOfRain: Int,
//    @SerializedName("daily_chance_of_snow")
//    val dailyChanceOfSnow: Int,
//    @SerializedName("daily_will_it_rain")
//    val dailyWillItRain: Int,
//    @SerializedName("daily_will_it_snow")
//    val dailyWillItSnow: Int,
    @SerializedName("maxtemp_c")
    val maxtemp_c: Float,
//    @SerializedName("maxtemp_f")
//    val maxtempF: Double,
//    @SerializedName("maxwind_kph")
//    val maxwindKph: Double,
//    @SerializedName("maxwind_mph")
//    val maxwindMph: Double,
    @SerializedName("mintemp_c")
    val mintemp_c: Float,
//    @SerializedName("mintemp_f")
//    val mintempF: Double,
//    @SerializedName("totalprecip_in")
//    val totalprecipIn: Double,
//    @SerializedName("totalprecip_mm")
//    val totalprecipMm: Double,
//    @SerializedName("totalsnow_cm")
//    val totalsnowCm: Double,
//    @SerializedName("uv")
//    val uv: Double
)