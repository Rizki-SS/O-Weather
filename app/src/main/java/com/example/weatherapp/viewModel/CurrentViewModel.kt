package com.example.weatherapp.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.apiService.ApiClient
import com.example.weatherapp.apiService.ApiService
import com.example.weatherapp.model.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class CurrentViewModel:ViewModel(){
    private var currentWeatherData: MutableLiveData<WeatherModel> = MutableLiveData<WeatherModel>()
    private var city:String = "Malang"
    private val dateFormat = SimpleDateFormat("EEE, dd MMM yyyy")
    private val currentDate = dateFormat.format(Date())

    fun init(){
        val service: ApiService = ApiClient().getApiServic()
        service.getWeather("369e449d9e7ad63c71649683cfc00dba", city, "metric")
            .enqueue(object: Callback<WeatherModel> {
                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }
                override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                    currentWeatherData.value=response.body()
                }
            })
    }

    fun getCurrentWeatherData(): LiveData<WeatherModel>? {
        return currentWeatherData
    }

    fun getCurrentDate(): String? {
        return currentDate
    }

    fun convertTime(unix:Int): String?{
        val dateFormat = SimpleDateFormat("hh : mm")
        val currentDate = dateFormat.format(Date(unix.toLong() * 1000))
        return currentDate
    }

    fun getCity():String{
        return city
    }
}