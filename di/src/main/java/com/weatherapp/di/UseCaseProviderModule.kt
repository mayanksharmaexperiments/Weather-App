package com.weatherapp.di

import com.weatherapp.domain.repository.IWeatherRepository
import com.weatherapp.domain.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseProviderModule {

    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: IWeatherRepository): WeatherUseCase =
        WeatherUseCase(repository)

}