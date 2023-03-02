package com.example.challenge.network.api

import com.google.gson.*
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.lang.reflect.Type

const val API_KEY : String = "63837e27b47d4b8c81582817232102"
const val API_URL : String = "http://api.weatherapi.com"

private val okHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

private val gson = GsonBuilder()
    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    .registerTypeAdapter(Double::class.java, object : JsonSerializer<Double> {
        override fun serialize(
            src: Double,
            typeOfSrc: Type?,
            context: JsonSerializationContext?
        ): JsonElement {
            return JsonPrimitive("%.2f".format(src))
        }
    }).create()

fun retrofit() : Retrofit =
    Retrofit.Builder()
        .baseUrl(API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

fun apiService(): WeatherAPI =
    retrofit().create(WeatherAPI::class.java)