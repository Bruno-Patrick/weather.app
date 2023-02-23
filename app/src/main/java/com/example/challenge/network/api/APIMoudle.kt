package com.example.challenge.network.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val API_KEY : String = "63837e27b47d4b8c81582817232102"
val API_URLS : List<String> = listOf("https://api.open-meteo.com/","http://api.weatherapi.com")

fun client() =
    OkHttpClient.Builder()
        .connectTimeout(10,TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

fun gson() : Gson = GsonBuilder().create()

fun retrofit() : Retrofit =
    Retrofit.Builder()
        .baseUrl(API_URLS[1].toString())
        .client(client())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()

fun apiService(): WeatherAPI =
    retrofit().create(WeatherAPI::class.java)