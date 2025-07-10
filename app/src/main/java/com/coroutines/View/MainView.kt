package com.coroutines.View

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coroutines.retrofit.R

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coroutines.Model.WeatherResponse
import com.coroutines.Service.NetworkClient
import kotlinx.coroutines.*

class MainView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val apiKey = "1a03ac2ebe3574faa807d45a045c57ab"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchWeatherData()
    }

    private fun fetchWeatherData() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val cities = listOf("London", "Paris", "Berlin")
                val weatherList = mutableListOf<WeatherResponse>()

                for (city in cities) {
                    val response = NetworkClient.weatherService.getWeather(city, apiKey)
                    weatherList.add(response)
                }

                withContext(Dispatchers.Main) {
                    recyclerView.adapter = WeatherAdapter(weatherList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}