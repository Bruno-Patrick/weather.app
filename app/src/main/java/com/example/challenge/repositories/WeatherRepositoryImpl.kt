package com.example.challenge.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.domain.repository.WeatherRepository
import com.example.challenge.network.api.apiService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherRepositoryImpl : WeatherRepository {

    private val apiService = apiService()
    private val weatherData = MutableLiveData<WeatherModel>()

    override suspend fun getWeatherDataAsync(lat: Double, long: Double): LiveData<WeatherModel> {
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiService.getWeatherData(latitude = lat, longitude = long)
            if (response.isSuccessful) {
                val gson = Gson()
                val weatherDto = response.body()
                val weather = gson.fromJson(gson.toJson(weatherDto), WeatherModel::class.java)
                weatherData.postValue(weather)
            }
        }
        return weatherData
    }
}