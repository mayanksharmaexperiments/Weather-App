package com.weatherapp.forecast

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.ForecastResponseEntity
import com.weatherapp.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase) :
    ViewModel() {

    val forecastResponse = MutableLiveData<Resource<ForecastResponseEntity>>()

    fun fetchForecast(city: String) = viewModelScope.launch(Dispatchers.IO) {
        forecastResponse.postValue(Resource.Loading())
        weatherUseCase.fetchForecast(city, days = FORECAST_DAYS).collect { response ->
            forecastResponse.postValue(response)
        }
    }

    companion object {
        const val FORECAST_DAYS = 5
    }

}
