package com.weatherapp.domain.entity


data class ForecastResponseEntity(
    val forecast: ForecastEntity
)

data class ForecastEntity(
    val forecastDays: List<ForecastDayEntity>
)

data class ForecastDayEntity(
    val date: String,
    val day : DayEntity
)

data class DayEntity(
    val maxTempC: Double,
    val minTempC: Double,
    val condition: ConditionEntity
)
