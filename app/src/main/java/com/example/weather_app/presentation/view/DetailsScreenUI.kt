package com.example.weather_app.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_app.data.model.*
import java.time.Instant
import java.time.ZoneId

@Composable
fun DetailsScreenUI(
    main: Main,
    clouds: Clouds,
    wind: Wind,
    precipitation: Precipitation
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier
                .padding(1.dp, 1.dp)
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(28.dp),
            elevation = 4.dp
        ) {
            Surface {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "Temperature Forecast",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = Color.Blue
                    )
                    Text(
                        text = "Dew Point : " + main.dewPoint.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Temperature : " + main.temp.toString(),
                        style = MaterialTheme.typography.caption,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )
                    Text(
                        text = "Humidity : " + main.humidity.toString(),
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Pressure : " + main.pressure.toString(),
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(1.dp, 1.dp)
                .fillMaxWidth()
                .height(120.dp),
            shape = RoundedCornerShape(28.dp),
            elevation = 4.dp

        ) {
            Surface {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ) {
                    Text(
                        text = "Precipitation",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = Color.Blue
                    )
                    Text(
                        text = "Convective : " + precipitation.convective.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Rain Forecast : " + precipitation.frRain.toString(),
                        style = MaterialTheme.typography.caption,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )
                    Text(
                        text = "Rate : " + precipitation.rate.toString(),
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Ice : " + precipitation.ice.toString(),
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Accumulated : " + precipitation.accumulated.toString(),
                        style = MaterialTheme.typography.body1,
                        fontSize = 24.sp
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(1.dp, 1.dp)
                .width(300.dp)
                .height(120.dp),
            shape = RoundedCornerShape(28.dp),
            elevation = 4.dp
        ) {
            Surface(
                color = Color.Green
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(1.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())

                ) {
                    Text(
                        text = "Wind Forecast",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 34.sp,
                        color = Color.Blue
                    )
                    Text(
                        text = "Degree : " + wind.deg.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Speed : " + wind.speed.toString(),
                        style = MaterialTheme.typography.caption,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(4.dp)
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .padding(1.dp, 1.dp)
                .width(200.dp)
                .height(120.dp),
            shape = RoundedCornerShape(28.dp),
            elevation = 4.dp
        ) {
            Surface {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(1.dp)
                        .width(100.dp)
                        .height(100.dp)

                ) {
                    Text(
                        text = "Clouds : " + clouds.all.toString(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
fun ForecastDetailsPreview() {
    DetailsScreenUI(
        main = Main(8.08,1034.848,4.63,1029.908,78.61),
        clouds = Clouds(42),
        wind = Wind(4.254,320.074),
        precipitation = Precipitation(0,0,0,0)
    )
}
