package com.example.weatherapp.viewModel

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.weatherapp.apiService.ApiClient
import com.example.weatherapp.apiService.ApiService
import com.example.weatherapp.model.WeatherModel
import com.example.weatherapp.view.HomeDirections
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class CurrentViewModel:ViewModel(){
    private val _currentWeather = MutableLiveData<WeatherModel>()
    val currentWeather: LiveData<WeatherModel> get() = _currentWeather

    private val _city = MutableLiveData<String>()
    val city: LiveData<String> get() = _city

    fun init(){
        if (city.value.isNullOrBlank()){
            _city.value = "Malang"
        }
        val service: ApiService = ApiClient().getApiServic()
        service.getWeather("369e449d9e7ad63c71649683cfc00dba", city.value.toString(), "metric")
            .enqueue(object: Callback<WeatherModel> {
                override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                    Log.d("Request failed", "No Internet Access")
                }
                override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                    _currentWeather.value=response.body()
                }
            })
    }

    fun setCityName(city:String){
        _city.value = city
    }

    fun onForecastClick(view:View){
        var action = HomeDirections.actionHome2ToForecastFragment2()
        action.requestCity = _city.value.toString()
        view.findNavController().navigate(action)
    }

    fun onSetCityClick(view: View){
        var action = HomeDirections.actionHome2ToCityFragment()
        view.findNavController().navigate(action)
    }
}