package com.weatherapp.domain.entity

data class CurrentWeatherResponseEntity(
    val current: CurrentEntity
)


data class CurrentEntity(
    val tempC: Double,
    val condition: ConditionEntity,
    val humidity: Int,
    val windKph: Double
)

data class ConditionEntity(
    val text: String,
    val icon: String,
)
