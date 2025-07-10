package com.coroutines.Model

//data class WeatherResponse(
//    @SerializedName("title") val title:String,
//    @SerializedName("consolidated_weather") val consolidatedWeather:List<WeatherInfo>
//)

data class WeatherResponse(
    val name: String,
    val main: Main,
    val weather: List<Weather>
)

data class Main(
    val temp: Double,
    val humidity: Int
)

data class Weather(
    val description: String,
    val icon: String
)