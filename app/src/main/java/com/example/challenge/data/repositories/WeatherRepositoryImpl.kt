package com.example.challenge.data.repositories


import com.example.challenge.domain.repository.WeatherRepository
import com.example.challenge.domain.repository.WeatherRepository.Companion.dispatcher
import com.example.challenge.network.api.API_KEY
import com.example.challenge.network.api.apiService
import com.example.challenge.network.dto.WeatherDTO

import kotlinx.coroutines.*
import retrofit2.Response

class WeatherRepositoryImpl : WeatherRepository {

    private val apiService = apiService()

    private val hourly : String = "temperature_2m"
    private val daily : String = "weathercode"
    private val timezone : String = "UTC"

    override suspend fun getWeatherData(q: String): Response<WeatherDTO> {
        return withContext(dispatcher) {
            return@withContext apiService.getWeatherData(q = q, key = API_KEY, days = 7, lang = "pt")
        }
    }

}