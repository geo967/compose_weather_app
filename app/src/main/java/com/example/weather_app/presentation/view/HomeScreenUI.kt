package com.example.weather_app.presentation.view

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.weather_app.R
import com.example.weather_app.presentation.MainActivity2
import com.example.weather_app.data.model.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.time.Instant
import java.time.ZoneId

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun WeatherItem(
    responseItem: ResponseItem,
) {
    val dateTime: String = Instant.ofEpochSecond(responseItem.dt!!.toLong())
        .atZone(ZoneId.systemDefault())
        .toLocalDateTime().toString()
    val dateTimeSplit = dateTime.split("T")
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(28.dp, 20.dp)
            .width(350.dp)
            .height(110.dp),
        shape = RoundedCornerShape(68.dp),
        elevation = 4.dp,
        ) {
        Surface(
            color = Color.Blue,
            onClick = {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("Clouds", responseItem.clouds)
                intent.putExtra("Main", responseItem.main)
                intent.putExtra("Precipitation", responseItem.precipitation)
                intent.putExtra("Wind", responseItem.wind)
                context.startActivity(intent)
            }
        ) {
            Row(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.8f)
                ) {
                    Text(
                        text = "Date : " + dateTimeSplit[0],
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.Red
                    )
                    Text(
                        text = "Time : " + dateTimeSplit[1],
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.Green
                    )
                }
            }
        }
    }
}
@ExperimentalMaterialApi
@Composable
@Preview
fun ExpandableCardPreview() {
    WeatherItem(
        responseItem= ResponseItem(dt = 1546300800)
    )
}

