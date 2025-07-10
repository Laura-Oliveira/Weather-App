package com.coroutines.View

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coroutines.Model.WeatherResponse
import com.coroutines.retrofit.R

class WeatherAdapter(private val items: List<WeatherResponse>)
    : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCityName = itemView.findViewById<TextView>(R.id.tvCityName)
        val tvTemperature = itemView.findViewById<TextView>(R.id.tvTemperature)
        val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        val tvHumidity = itemView.findViewById<TextView>(R.id.tvHumidity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = items[position]
        holder.tvCityName.text = item.name
        holder.tvTemperature.text = "Temp: ${item.main.temp}°C"
        holder.tvDescription.text = item.weather.firstOrNull()?.description ?: "-"
        holder.tvHumidity.text = "Humidity: ${item.main.humidity}%"
    }

    override fun getItemCount() = items.size
}