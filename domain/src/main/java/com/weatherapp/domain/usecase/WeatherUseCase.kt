package com.weatherapp.domain.usecase

import com.weatherapp.domain.repository.IWeatherRepository

class WeatherUseCase(private val repository: IWeatherRepository) {

    fun searchCity(
        city: String
    ) = repository.searchCity(city)

    fun fetchCurrentWeather(
        location: String,
    ) = repository.fetchCurrentWeather(location)

    fun fetchForecast(
        location: String,
        days: Int,
    ) = repository.fetchForecast(location, days)

}