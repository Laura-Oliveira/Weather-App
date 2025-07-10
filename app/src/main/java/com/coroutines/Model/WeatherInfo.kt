package com.coroutines.Model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(
    @SerializedName("weather_state_name") val weatherName:String,
    @SerializedName("min_temp") val weatherMinTemperature:Float,
    @SerializedName("max_temp") val weatherMaxTemperature:Float,
    @SerializedName("the_temp") val weatherTemperature:Float
)