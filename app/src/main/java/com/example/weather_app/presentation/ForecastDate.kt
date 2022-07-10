package com.example.weather_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.ui.theme.Weather_appTheme
import com.example.weather_app.view.WeatherItem
import com.example.weather_app.presentation.viewmodel.WeatherForecastViewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel by viewModels<WeatherForecastViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Blue
                ) {
                    WeatherList(weatherList = weatherViewModel.weatherForecastResponse)
                    weatherViewModel.getWeatherForecast()
                }
            }
        }


    }
}

@Composable
fun WeatherList(weatherList:List<ResponseItem>) {
    LazyColumn{
        itemsIndexed(items=weatherList){ _, item ->
            WeatherItem(responseItem = item)
        }
    }
}
