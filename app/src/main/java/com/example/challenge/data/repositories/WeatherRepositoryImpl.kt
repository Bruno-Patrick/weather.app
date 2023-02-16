package com.example.challenge.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.domain.repository.WeatherRepository
import com.example.challenge.network.api.apiService
import com.google.gson.Gson
import kotlinx.coroutines.*

class WeatherRepositoryImpl : WeatherRepository {

    private val apiService = apiService()
    private var weatherData = MutableLiveData<WeatherModel>()
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val hourly = listOf("temperature_2m", "pressure_msl", "relativehumidity_2m", "windspeed_10m")
    private val daily : String = "weathercode"
    private val timezone : String = "UTC"

    override suspend fun getWeatherDataAsync(lat: Double, long: Double): LiveData<WeatherModel> {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                apiService.getWeatherData(lat = lat,long = long,hourly = hourly,daily = daily,timezone = timezone).let { response ->
                    response.isSuccessful.let {
                        Gson().let { gson ->
                            response.body().let { weatherDTO ->
                                gson.fromJson(gson.toJson(weatherDTO), WeatherModel::class.java).let {
                                    weatherData.postValue(it)
                                }
                            }
                        }
                    }
                }
            } catch (e : Exception) {
                println("EXCEPTION WAS BEEN RAISED $e")
            }
        }
        println("WEATHER REPOSITORY IMPL")
        return weatherData
    }

}