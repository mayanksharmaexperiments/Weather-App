package com.weatherapp.di

import com.weatherapp.data.api.IWeatherApi
import com.weatherapp.data.repository.WeatherRepositoryImpl
import com.weatherapp.domain.repository.IWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideWeatherRepository(service: IWeatherApi): IWeatherRepository =
        WeatherRepositoryImpl(service)

}