package com.example.challenge.domain.repository

import androidx.lifecycle.LiveData
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.network.dto.WeatherDTO
import retrofit2.Response

interface WeatherRepository {

    suspend fun getWeatherDataAsync(lat : Double, long : Double) : LiveData<WeatherModel>

}