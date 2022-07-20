
package com.example.weather_app.data.repository

import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.data.network.ApiService
import javax.inject.Inject

class WeatherDetailsRepo @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getWeatherForecastData(): List<ResponseItem> {
        return apiService.getWeatherForecastList()
    }
}