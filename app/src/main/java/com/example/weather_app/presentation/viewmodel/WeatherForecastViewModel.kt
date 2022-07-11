package com.example.weather_app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.domain.usecase.ApiData
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherForecastViewModel : ViewModel() {
    var weatherForecastResponse: List<ResponseItem> by mutableStateOf(listOf())

    var errorMessage: String by mutableStateOf("")

    fun getWeatherForecast() {
        viewModelScope.launch {
            try {
                weatherForecastResponse = ApiData.getWeatherForecastData()
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}