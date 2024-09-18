package com.weatherapp.data.repository

import com.weatherapp.data.BuildConfig
import com.weatherapp.data.api.IWeatherApi
import com.weatherapp.data.utils.ERROR_UNKNOWN
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.CurrentWeatherResponseEntity
import com.weatherapp.domain.entity.ForecastResponseEntity
import com.weatherapp.domain.entity.SearchCityResponseEntity
import com.weatherapp.domain.repository.IWeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(private val apiService: IWeatherApi) : IWeatherRepository {
    override fun searchCity(
        city: String
    ): Flow<Resource<List<SearchCityResponseEntity>>> = flow {
        emit(Resource.Loading())
        val response = apiService.searchCity(BuildConfig.WEATHER_API_KEY, city)
        emit(Resource.Success(response.body()?.map { it.mapToEntity() }))
    }.catch { e ->
        emit(Resource.Error(e.message ?: ERROR_UNKNOWN))
    }

    override fun fetchCurrentWeather(
        location: String
    ): Flow<Resource<CurrentWeatherResponseEntity>> = flow {
        emit(Resource.Loading())
        val response = apiService.fetchCurrentWeather(BuildConfig.WEATHER_API_KEY, location)
        emit(Resource.Success(response.body()?.mapToEntity()))
    }.catch { e ->
        emit(Resource.Error(e.message ?: ERROR_UNKNOWN))
    }

    override fun fetchForecast(
        location: String,
        days: Int
    ): Flow<Resource<ForecastResponseEntity>> = flow {
        emit(Resource.Loading())
        val response = apiService.fetchForecast(BuildConfig.WEATHER_API_KEY, location, days)
        emit(Resource.Success(response.body()?.mapToEntity()))
    }.catch { e ->
        emit(Resource.Error(e.message ?: ERROR_UNKNOWN))
    }
}