package com.example.weather_app.domain.di

import com.example.weather_app.data.network.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetroModule {

    @Singleton
    @Provides
    fun providesAPI(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://mocki.io/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
