package com.example.challenge.network.api

import com.example.challenge.network.dto.WeatherDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherAPI {

    @GET("v1/forecast?latitude={lat}&longitude={long}&hourly=temperature_2m,pressure_msl,relativehumidity_2m,windspeed_10m&daily=weathercode&timezone=UTC")
    suspend fun getWeatherData(
        @Path(value = "lat") latitude : Double,
        @Path(value = "long") longitude : Double
    ) : Response<WeatherDTO>

}
