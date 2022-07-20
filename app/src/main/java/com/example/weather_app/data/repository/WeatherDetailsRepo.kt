
package com.example.weather_app.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.domain.di.RetroServiceInterface
import javax.inject.Inject

class WeatherDetailsRepo @Inject constructor(
    private val retroServiceInterface: RetroServiceInterface
) {
    private val _contents = MutableLiveData<List<ResponseItem>>()
    val contents: LiveData<List<ResponseItem>>
        get() = _contents

    suspend fun getWeatherData() {
        val result = retroServiceInterface.getWeatherForecastList()
        if (result.isSuccessful && result.body() != null) {
            _contents.postValue(result.body())
        }
    }
}