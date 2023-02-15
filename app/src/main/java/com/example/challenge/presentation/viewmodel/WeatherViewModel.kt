package com.example.challenge.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.challenge.repositories.WeatherRepositoryImpl
import com.example.challenge.domain.model.WeatherModel


class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl()

    suspend fun getWeatherData(lat : Double, long : Double) : LiveData<WeatherModel> = repository.getWeatherDataAsync(lat = lat, long = long)

}