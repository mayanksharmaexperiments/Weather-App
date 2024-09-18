package com.weatherapp.data.datamodel

import com.google.gson.annotations.SerializedName
import com.weatherapp.domain.entity.ConditionEntity
import com.weatherapp.domain.entity.CurrentEntity
import com.weatherapp.domain.entity.CurrentWeatherResponseEntity

data class CurrentWeatherResponseModel(
    @SerializedName("current")
    val current: CurrentModel,
) {
    fun mapToEntity() = CurrentWeatherResponseEntity(current.mapToEntity())
}


data class CurrentModel(
    @SerializedName("temp_c")
    val tempC: Double,
    @SerializedName("condition")
    val condition: ConditionModel,
    @SerializedName("humidity")
    val humidity: Int,
    @SerializedName("wind_kph")
    val windKph: Double
) {
    fun mapToEntity() = CurrentEntity(tempC, condition.mapToEntity(), humidity, windKph)
}

data class ConditionModel(
    @SerializedName("text")
    val text: String,
    @SerializedName("icon")
    val icon: String,
) {
    fun mapToEntity() = ConditionEntity(text, icon)
}
