package com.example.weather_app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.data.repository.WeatherDetailsRepo
import kotlinx.coroutines.launch

class WeatherForecastViewModel(private val repo: WeatherDetailsRepo) : ViewModel() {

    var contentLiveData: List<ResponseItem> by mutableStateOf(listOf())

    init {
        viewModelScope.launch {
            contentLiveData = repo.getWeatherForecastData()
        }
    }
}