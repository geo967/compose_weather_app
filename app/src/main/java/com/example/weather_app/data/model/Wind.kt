package com.example.weather_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Wind(

    @field:SerializedName("deg")
    val deg: Double? = null,

    @field:SerializedName("speed")
    val speed: Double? = null

): Serializable
