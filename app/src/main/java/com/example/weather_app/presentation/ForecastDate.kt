package com.example.weather_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter.State.Empty.painter
import com.example.weather_app.R
import com.example.weather_app.data.model.ResponseItem
import com.example.weather_app.presentation.ui.theme.Weather_appTheme
import com.example.weather_app.presentation.view.WeatherItem
import com.example.weather_app.presentation.viewmodel.WeatherForecastViewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel by viewModels<WeatherForecastViewModel>()

    @OptIn(ExperimentalCoilApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                        contentScale = ContentScale.Fit
                    )
                    WeatherList(weatherList = weatherViewModel.weatherForecastResponse)
                    weatherViewModel.getWeatherForecast()
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
