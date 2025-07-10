package com.coroutines.Service

import com.coroutines.Model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


//requisicoes rest feitas dentro de interfaces
//interface WeatherService
//{
//    //funcoes de interface nao tem implementacao
//    @GET("4418.json")
//    suspend fun getWeather():WeatherResponse
//}


interface WeatherService {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherResponse
}