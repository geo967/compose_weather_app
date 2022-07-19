package com.example.weather_app.domain.di

import com.example.weather_app.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivity: MainActivity)

}
