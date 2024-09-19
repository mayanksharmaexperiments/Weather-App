package com.weatherapp.currentweather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.CurrentWeatherResponseEntity
import com.weatherapp.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentWeatherViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase) :
    ViewModel() {

    val currentWeatherResponse = MutableLiveData<Resource<CurrentWeatherResponseEntity>>()

    fun fetchCurrentWeather(city: String) = viewModelScope.launch(Dispatchers.IO) {
        currentWeatherResponse.postValue(Resource.Loading())
        weatherUseCase.fetchCurrentWeather(city).collect { response ->
            currentWeatherResponse.postValue(response)
        }
    }

}
