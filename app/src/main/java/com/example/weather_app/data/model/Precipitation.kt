package com.example.weather_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Precipitation(

    @field:SerializedName("convective")
    val convective: Int? = null,

    @field:SerializedName("fr_rain")
    val frRain: Int? = null,

    @field:SerializedName("rate")
    val rate: Int? = null,

    @field:SerializedName("ice")
    val ice: Int? = null,

    @field:SerializedName("accumulated")
    val accumulated: Int? = null

):Serializable


