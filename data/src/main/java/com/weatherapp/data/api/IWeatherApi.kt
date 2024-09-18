package com.weatherapp.data.api

import com.weatherapp.data.utils.CURRENT_WEATHER
import com.weatherapp.data.utils.FORECAST
import com.weatherapp.data.utils.SEARCH_CITY
import com.weatherapp.data.datamodel.CurrentWeatherResponseModel
import com.weatherapp.data.datamodel.ForecastResponseModel
import com.weatherapp.data.datamodel.SearchCityResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApi {

    @GET(SEARCH_CITY)
    suspend fun searchCity(
        @Query("key") apiKey: String,
        @Query("q") query: String
    ): Response<List<SearchCityResponseModel>>

    @GET(CURRENT_WEATHER)
    suspend fun fetchCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
    ): Response<CurrentWeatherResponseModel>


    @GET(FORECAST)
    suspend fun fetchForecast(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int,
    ): Response<ForecastResponseModel>

}