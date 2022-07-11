package com.example.weather_app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.weather_app.data.model.*
import com.example.weather_app.ui.theme.Weather_appTheme
import com.example.weather_app.presentation.view.DetailsScreenUI

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Weather_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    GetData()
                }
            }
        }
    }
}

@Composable
fun GetData() {
    val context = LocalContext.current
    val intent = (context as MainActivity2).intent
    val responseItem = intent.getSerializableExtra("ResponseItem") as ResponseItem
    val clouds = intent.getSerializableExtra("Clouds") as Clouds
    val main = intent.getSerializableExtra("Main") as Main
    val wind = intent.getSerializableExtra("Wind") as Wind
    val precipitation = intent.getSerializableExtra("Precipitation") as Precipitation
    DetailsScreenUI(
        responseItem = responseItem,
        main = main,
        clouds = clouds,
        wind = wind,
        precipitation = precipitation
    )

}
