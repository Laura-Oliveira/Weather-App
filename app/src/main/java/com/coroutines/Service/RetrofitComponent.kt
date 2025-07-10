package com.coroutines.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitComponent
{
    private val url:String = "https://cdn.faire.com/static/mobile-take-home/"
    //cria a instancia do retrofit
    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // .addConverterFactory(GsonConverterFactory.create()) adiciona um serializador para transformar os dados json
        // em dados que possam ser manipulados dentro do projeto
        .addConverterFactory(GsonConverterFactory.create())
        //cria a instancia do retrofit
        .build()

    //o retrofit transforma a classe WeatherService em um servico para poder fazer as chamadas necessarias
    val networkService:WeatherService = retrofit.create(WeatherService::class.java)




}