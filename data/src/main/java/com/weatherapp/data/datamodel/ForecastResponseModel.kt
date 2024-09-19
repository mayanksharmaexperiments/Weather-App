package com.weatherapp.data.datamodel

import com.google.gson.annotations.SerializedName
import com.weatherapp.domain.entity.DayEntity
import com.weatherapp.domain.entity.ForecastDayEntity
import com.weatherapp.domain.entity.ForecastEntity
import com.weatherapp.domain.entity.ForecastResponseEntity

data class ForecastResponseModel(
    @SerializedName("forecast")
    val forecast: ForecastModel
) {
    fun mapToEntity() = ForecastResponseEntity(forecast.mapToEntity())
}

data class ForecastModel(
    @SerializedName("forecastday")
    val forecastDays: List<ForecastDayModel>
) {
    fun mapToEntity() = ForecastEntity(forecastDays.map { it.mapToEntity() })
}

data class ForecastDayModel(
    @SerializedName("date")
    val date: String,
    @SerializedName("day")
    val day: DayModel
) {
    fun mapToEntity() = ForecastDayEntity(date, day.mapToEntity())
}

data class DayModel(
    @SerializedName("maxtemp_c")
    val maxTempC: Double,
    @SerializedName("mintemp_c")
    val minTempC: Double,
    @SerializedName("condition")
    val condition: ConditionModel
) {
    fun mapToEntity() = DayEntity(maxTempC, minTempC, condition.mapToEntity())
}

