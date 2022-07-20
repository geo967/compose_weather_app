package com.example.weather_app.domain.usecase

import com.example.weather_app.data.model.*
import com.example.weather_app.data.repository.WeatherDetailsRepo

interface GetWeatherDetails {
    companion object {
        private lateinit var weatherForecastResponse: List<ResponseItem>
        lateinit var repo: WeatherDetailsRepo
        private lateinit var errorMessage: String

        suspend fun getWeatherForecastData(): List<ResponseItem> {
            return try {
                weatherForecastResponse = repo.getWeatherForecastData()
                weatherForecastResponse
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                listOf(
                    ResponseItem(0,
                        Precipitation(
                            0,
                            0,
                            0,
                            0,
                            0
                        ),
                        Main(
                            0.0,
                            0.0,
                            0.0,
                            0.0,
                            0.0
                        ),
                        Clouds(0),
                        Wind(0.0, 0.0)
                    )
                )
            }
        }
    }
}