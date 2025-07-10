package com.coroutines.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
  //  private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    val weatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }
}