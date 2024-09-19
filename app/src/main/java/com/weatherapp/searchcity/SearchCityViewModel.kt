package com.weatherapp.searchcity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.domain.Resource
import com.weatherapp.domain.entity.SearchCityResponseEntity
import com.weatherapp.domain.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SearchCityViewModel @Inject constructor(private val weatherUseCase: WeatherUseCase) :
    ViewModel() {

    val userInputCity = MutableStateFlow<String?>(null)

    val searchCityResponse = MutableLiveData<Resource<List<SearchCityResponseEntity>>>()

    init {
        observeCity()
    }

    private fun observeCity() = viewModelScope.launch(Dispatchers.IO) {
        userInputCity.debounce(DELAY_FOR_FETCHING_CITY.toLong())
            .collect {
                it?.let { city ->
                    searchCity(city)
                }
            }
    }

    private fun searchCity(city: String) = viewModelScope.launch(Dispatchers.IO) {
        searchCityResponse.postValue(Resource.Loading())
        weatherUseCase.searchCity(city).collect { response ->
            searchCityResponse.postValue(response)
        }
    }


    companion object {
        const val DELAY_FOR_FETCHING_CITY = 1200
    }

}
