
package com.example.weather_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather_app.data.repository.WeatherDetailsRepo
import javax.inject.Inject

class WeatherForecastViewModelFactory @Inject constructor(
    private val repo:WeatherDetailsRepo
): ViewModelProvider.Factory{
       override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherForecastViewModel(repo) as T
    }
}