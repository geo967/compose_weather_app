package com.example.weather_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseItem(

    @field:SerializedName("dt")
    val dt: Int? = null,

    @field:SerializedName("precipitation")
    val precipitation: Precipitation? = null,

    @field:SerializedName("main")
    val main: Main? = null,

    @field:SerializedName("clouds")
    val clouds: Clouds? = null,

    @field:SerializedName("wind")
    val wind: Wind? = null
): Serializable
