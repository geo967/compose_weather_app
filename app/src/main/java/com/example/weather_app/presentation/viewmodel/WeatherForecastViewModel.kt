package com.example.weather_app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.data.repository.WeatherDetailsRepo
import com.example.weather_app.domain.di.RetroServiceInterface
import com.example.weather_app.domain.usecase.ApiData
import kotlinx.coroutines.launch
import javax.inject.Inject

class WeatherForecastViewModel/*(val repo: WeatherDetailsRepo)*/ : ViewModel() {

/*    @Inject
    lateinit var retroService: RetroServiceInterface
    val contentLiveData: LiveData<List<ResponseItem>>
    get()=repo.contents
    init {
        viewModelScope.launch {
            repo.getWeatherData()
        }
    }*/

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