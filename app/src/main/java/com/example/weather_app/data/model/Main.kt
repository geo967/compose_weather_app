package com.example.weather_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Main(

    @field:SerializedName("temp")
    val temp: Double? = null,

    @field:SerializedName("dew_point")
    val dewPoint: Double? = null,

    @field:SerializedName("grnd_pressure")
    val grndPressure: Double? = null,

    @field:SerializedName("humidity")
    val humidity: Double? = null,

    @field:SerializedName("pressure")
    val pressure: Double? = null
): Serializable
