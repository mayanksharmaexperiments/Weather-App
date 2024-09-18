package com.weatherapp.domain.repository

import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.CurrentWeatherResponseEntity
import com.weatherapp.domain.entity.ForecastResponseEntity
import com.weatherapp.domain.entity.SearchCityResponseEntity
import kotlinx.coroutines.flow.Flow

interface IWeatherRepository {

    fun searchCity(
        city: String
    ): Flow<Resource<List<SearchCityResponseEntity>>>

    fun fetchCurrentWeather(
        location: String,
    ): Flow<Resource<CurrentWeatherResponseEntity>>

    fun fetchForecast(
        location: String,
        days: Int,
    ): Flow<Resource<ForecastResponseEntity>>
}