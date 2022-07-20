package com.example.weather_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import coil.annotation.ExperimentalCoilApi
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.domain.di.DaggerRetroComponent
import com.example.weather_app.domain.di.RetroComponent
import com.example.weather_app.presentation.ui.theme.Weather_appTheme
import com.example.weather_app.presentation.view.WeatherItem
import com.example.weather_app.presentation.viewmodel.WeatherForecastViewModel
import com.example.weather_app.presentation.viewmodel.WeatherForecastViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    private lateinit var retroComponent: RetroComponent
    lateinit var weatherForecastViewModel: WeatherForecastViewModel

    @Inject
    lateinit var weatherForecastViewModelFactory: WeatherForecastViewModelFactory

    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retroComponent = DaggerRetroComponent.builder().build()
        retroComponent.inject(this)

        weatherForecastViewModel =
            ViewModelProvider(this, weatherForecastViewModelFactory)
                .get(WeatherForecastViewModel::class.java)

        setContent {
            Weather_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black,
                ) {
                    WeatherList(weatherList = weatherForecastViewModel.contentLiveData)
                }
            }
        }
    }
}

@Composable
fun WeatherList(weatherList: List<ResponseItem>) {
    LazyColumn {
        itemsIndexed(items = weatherList) { _, item ->
            WeatherItem(responseItem = item)
        }
    }
}