package com.example.challenge.data.mappers

import com.example.challenge.domain.model.WeatherModel
import com.example.challenge.network.dto.WeatherDTO

fun weatherDataMapper(body : WeatherDTO?): WeatherModel? {
    var data : WeatherModel? = null

//    data?.current?.feelslikeC = body!!.current.feelslikeC
//    data?.current?.tempC = body!!.current.tempC
//    data?.current?.lastUpdated = body!!.current.lastUpdated
//    data?.location?.lon = body!!.location.lon
//    data?.location?.lat = body!!.location.lat
//    data?.location?.name = body!!.location.name
//    data?.location?.country = body!!.location.country
//    data?.location?.region = body!!.location.region

//    var i = 0
//    for (item in body!!.forecast.forecastday) {
//        data?.forecast!!.forecastday[i].date = item.date
//        data?.forecast!!.forecastday[i].day.avgtempC = item.day.avgtempC
//        data?.forecast!!.forecastday[i].day.maxtempC = item.day.maxtempC
//        data?.forecast!!.forecastday[i].day.mintempC = item.day.mintempC
//        data?.forecast!!.forecastday[i].hour.forEach(action = {
//            it.condition.code = item.hour[it.].condition.code
//        })
//        i++
//    }

    return data
}