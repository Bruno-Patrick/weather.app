package com.example.challenge.data.repositories


import com.example.challenge.domain.repository.WeatherRepository
import com.example.challenge.domain.repository.WeatherRepository.Companion.dispatcher
import com.example.challenge.network.api.apiService
import com.example.challenge.network.dto.WeatherDTO

import kotlinx.coroutines.*
import retrofit2.Response

class WeatherRepositoryImpl : WeatherRepository {

    private val apiService = apiService()

    private val hourly : String = "temperature_2m"
    private val daily : String = "weathercode"
    private val timezone : String = "UTC"

    override suspend fun getWeatherDataAsync(lat: Double, long: Double) : Response<WeatherDTO> {
        return withContext(dispatcher) {
            return@withContext apiService.getWeatherData(lat = lat, long = long, hourly = hourly, daily = daily, timezone = timezone)
        }
    }

}