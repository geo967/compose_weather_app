package com.example.weather_app.domain.usecase

import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.data.network.ApiService

interface ApiData {
    companion object {
        suspend fun getWeatherForecastData(): List<ResponseItem> {

            val apiService = ApiService.getInstance()
            return apiService.getWeatherForecastList()

        }
    }
}