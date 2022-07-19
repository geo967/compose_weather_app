package com.example.weather_app.domain.di


import com.example.weather_app.data.model.ResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface RetroServiceInterface {
    @GET("c0e70861-34ec-4905-99c0-97ee535b52b4")
    suspend fun getWeatherForecastList(): Response<List<ResponseItem>>
}
