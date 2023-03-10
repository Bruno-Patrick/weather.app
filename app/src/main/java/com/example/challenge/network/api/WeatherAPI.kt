package com.example.challenge.network.api

import com.example.challenge.network.dto.WeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

//    @GET("v1/forecast")
//    suspend fun getWeatherData(
//        @Query("latitude") lat: Double,
//        @Query("longitude") long: Double,
//        @Query("hourly") hourly: String,
//        @Query("daily") daily: String,
//        @Query("timezone") timezone: String
//    ) : Response<WeatherDTO>

    @GET("/v1/forecast.json")
    suspend fun getWeatherData(
        @Query("key") key: String,
        @Query("q") q: String,
        @Query("days") days: Int,
        @Query("lang") lang: String
    ) : Response<WeatherDTO>

}
