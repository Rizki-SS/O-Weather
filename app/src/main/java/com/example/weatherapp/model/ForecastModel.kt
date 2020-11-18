package com.example.weatherapp.model

data class ForecastModel(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<ListForecast>,
    val message: Int
)

data class City(
    val coord: Coord1,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)

data class ListForecast(
    val clouds: Clouds2,
    val dt: Int,
    val dt_txt: String,
    val main: Main1,
    val pop: Double,
    val rain: Rain,
    val sys: Sys1,
    val visibility: Int,
    val weather: List<Weather1>,
    val wind: Wind1
)

data class Coord1(
    val lat: Double,
    val lon: Double
)

data class Clouds2(
    val all: Int
)

data class Main1(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
)

data class Rain(
    val `3h`: Double
)

data class Sys1(
    val pod: String
)

data class Weather1(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

data class Wind1(
    val deg: Int,
    val speed: Double
)