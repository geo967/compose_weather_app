package com.example.weather_app.data.network

import com.example.weather_app.data.model.ResponseItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("c0e70861-34ec-4905-99c0-97ee535b52b4")
    suspend fun getWeatherForecastList(): List<ResponseItem>

    companion object {
        var apiService: ApiService? = null

        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://mocki.io/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)

            }
            return apiService!!
        }
    }
}