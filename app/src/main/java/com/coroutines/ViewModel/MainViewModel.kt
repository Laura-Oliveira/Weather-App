package com.coroutines.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coroutines.Service.RetrofitComponent
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val service = RetrofitComponent.networkService
    fun getWeatherData() {
        //cria o escopo e lança a courotine
        viewModelScope.launch {

            // .networkService transforma a classe de WeatherService em um servico de fato
            // .getWeather depois do servico criado e feita a requisicao get para backend/servidor e retorna os dados
//        val result = service.getWeather()
//            result.title
//            result.consolidatedWeather
        }
    }
}