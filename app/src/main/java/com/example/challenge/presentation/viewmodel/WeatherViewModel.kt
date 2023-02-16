package com.example.challenge.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.challenge.data.repositories.WeatherRepositoryImpl
import com.example.challenge.domain.model.WeatherModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl()
    private var data : WeatherModel? = null

    fun getWeatherData(lat : Double, long : Double): WeatherModel? {
        CoroutineScope(Dispatchers.IO).launch {
            repository.getWeatherDataAsync(lat = lat, long = long).let {
                data = it.value
            }
        }
        println("WEATHER VIEW MODEL")
        return data
    }
}