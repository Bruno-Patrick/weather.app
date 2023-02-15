package com.example.challenge.domain.repository

import androidx.lifecycle.LiveData
import com.example.challenge.domain.model.WeatherModel

interface WeatherRepository {

    suspend fun getWeatherDataAsync(lat : Double, long : Double) : LiveData<WeatherModel>

}