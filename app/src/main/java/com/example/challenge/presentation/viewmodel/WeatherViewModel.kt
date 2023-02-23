package com.example.challenge.presentation.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge.data.repositories.WeatherRepositoryImpl
import com.example.challenge.domain.model.HourlyModel
import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.domain.model2.Weather2Model
import com.example.challenge.domain.repository.WeatherRepository.Companion.dispatcher
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepositoryImpl()

    private val _weatherData = MutableLiveData<Weather2Model>()
    val weatherData: LiveData<Weather2Model>
        get() = _weatherData

//    private val _weatherData2 = MutableLiveData<Weather2Model>()
//    val weatherData2 : LiveData<Weather2Model>
//        get() = _weatherData2

//    fun getWeatherData(lat : Double, long : Double) {
//         CoroutineScope(dispatcher).launch {
//            repository.getWeatherDataAsync(lat, long).let { response ->
//                response.isSuccessful.let {
//                    response.body().let { body ->
//                        Gson().let { gson ->
//                            try {
//                                println("RESPONSE -> $body")
//
//                                gson.fromJson(gson.toJson(body), WeatherModel::class.java).let { weatherModel ->
//                                    weatherModel.hourly = body!!.hourly
//                                    _weatherData.postValue(weatherModel)
//                                    println("MODEL -> $weatherModel")
//                                }
//                            } catch (e : Exception) {
//                                println("GSON EXCEPTION -> $e")
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    fun getWeatherDataWithACityName(q : String) {
        CoroutineScope(dispatcher).launch {
            try {
                repository.getWeatherDataWithACityName(q).let { response ->
                    response.isSuccessful.let {
                        response.body().let { body ->
                            Gson().let { gson ->
                                gson.fromJson(gson.toJson(body),Weather2Model::class.java).let { weather2Model ->

                                    weather2Model.current.tempC = body!!.current.tempC
                                    weather2Model.current.feelslikeC = body!!.current.feelslikeC
                                    weather2Model.current.lastUpdated = body!!.current.lastUpdated

                                    weather2Model.location.name = body!!.location.name
                                    weather2Model.location.lon = body!!.location.lon
                                    weather2Model.location.region = body!!.location.region
                                    weather2Model.location.country = body!!.location.country

                                    weather2Model.forecast.forecastday = weather2Model.forecast.forecastday

                                    _weatherData.postValue(weather2Model)
                                    println("WEATHER 2 BODY -> $body")
                                    println("WEATHER 2 MODEL -> $weather2Model")
                                }
                            }
                        }
                    }
                }

            }   catch (e : Exception) {
                println("Exception occurred: $e")
            }
        }
    }
}