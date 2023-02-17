package com.example.challenge.domain.repository


import com.example.challenge.network.dto.WeatherDTO
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

interface WeatherRepository {

    companion object {
        val dispatcher: CoroutineDispatcher = Dispatchers.IO
    }

    suspend fun getWeatherDataAsync(lat : Double, long : Double): Response<WeatherDTO>

}