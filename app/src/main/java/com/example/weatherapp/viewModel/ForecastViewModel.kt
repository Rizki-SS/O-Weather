package com.example.weatherapp.viewModel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.weatherapp.ForecastItemAdaptor
import com.example.weatherapp.apiService.ApiClient
import com.example.weatherapp.apiService.ApiService
import com.example.weatherapp.model.ForecastModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastViewModel:ViewModel() {
    private val _forecastWeather = MutableLiveData<ForecastModel>()
    val forecastWeather: LiveData<ForecastModel> get() = _forecastWeather

    fun init(){
        val service:ApiService = ApiClient().getApiServic()
        service.getForecast("369e449d9e7ad63c71649683cfc00dba","Malang","metric")
            .enqueue(object :Callback<ForecastModel>{
                override fun onFailure(call: Call<ForecastModel>, t: Throwable) {
                    Log.d("Request failed", "No Internet Access")
                }

                override fun onResponse(
                    call: Call<ForecastModel>,
                    response: Response<ForecastModel>
                ) {
                    _forecastWeather.value = response.body()
                }

            })
    }

    fun onBack(view: View){
        Navigation.findNavController(view).navigateUp();
    }
}