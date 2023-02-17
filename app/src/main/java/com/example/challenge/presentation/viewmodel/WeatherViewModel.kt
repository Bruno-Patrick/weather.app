package com.example.challenge.presentation.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge.data.repositories.WeatherRepositoryImpl
import com.example.challenge.domain.model.HourlyModel
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.domain.repository.WeatherRepository.Companion.dispatcher
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl()
    private val _weatherData = MutableLiveData<WeatherModel>()
    val weatherData: LiveData<WeatherModel>
        get() = _weatherData

    fun getWeatherData(lat : Double, long : Double) {
         CoroutineScope(dispatcher).launch {
            repository.getWeatherDataAsync(lat, long).let { response ->
                response.isSuccessful.let {
                    response.body().let { body ->
                        Gson().let { gson ->
                            try {
                                println("RESPONSE -> $body")

                                gson.fromJson(gson.toJson(body), WeatherModel::class.java).let { weatherModel ->
                                    weatherModel.hourly = body!!.hourly
                                    _weatherData.postValue(weatherModel)
                                    println("MODEL -> $weatherModel")
                                }
                            } catch (e : Exception) {
                                println("GSON EXCEPTION -> $e")
                            }
                        }
                    }
                }
            }
        }
    }
}