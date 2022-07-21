package com.example.weather_app.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Clouds(

    @field:SerializedName("all")
    val all: Int? = null?:0

): Serializable
