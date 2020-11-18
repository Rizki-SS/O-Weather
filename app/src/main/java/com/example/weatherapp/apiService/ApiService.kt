package com.example.weatherapp.apiService

import com.example.weatherapp.model.ForecastModel
import com.example.weatherapp.model.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private var baseUrl: String = "https://api.openweathermap.org/data/2.5/"

interface ApiService {
    @GET("weather")
    fun getWeather(
        @Query("appid") key: String,
        @Query("q") city: String,
        @Query("units") unit: String
    ): Call<WeatherModel>

    @GET("forecast")
    fun getForecast(
        @Query("appid") key: String,
        @Query("q") city: String,
        @Query("units") unit: String
    ): Call<ForecastModel>
}