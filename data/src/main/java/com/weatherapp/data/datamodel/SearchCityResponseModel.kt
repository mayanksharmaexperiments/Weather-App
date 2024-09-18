package com.weatherapp.data.datamodel

import com.google.gson.annotations.SerializedName
import com.weatherapp.domain.entity.SearchCityResponseEntity

data class SearchCityResponseModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("country")
    val country: String
) {
    fun mapToEntity() = SearchCityResponseEntity(name, region, country)
}
