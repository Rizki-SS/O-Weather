package com.example.weatherapp.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.apiService.ApiClient
import com.example.weatherapp.apiService.ApiService
import com.example.weatherapp.model.ForecastModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class BskForecastViewModel:ViewModel() {
    private var tomorrowForecastData:MutableLiveData<ForecastModel> = MutableLiveData<ForecastModel>()

    fun init(){
        val service:ApiService = ApiClient().getApiServic()
        service.getForecast("369e449d9e7ad63c71649683cfc00dba","Malang","metric")
            .enqueue(object :Callback<ForecastModel>{
                override fun onFailure(call: Call<ForecastModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<ForecastModel>,
                    response: Response<ForecastModel>
                ) {
                    tomorrowForecastData.value = response.body()
                }

            })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getTomorrowData():String{
        val tomorrow = LocalDate.now().plusDays(1)
        val formattedTomorrow = tomorrow.format(DateTimeFormatter.ofPattern("EE, MMM d, yyy"))
        return formattedTomorrow
    }

    fun getTomorrowForecastData():LiveData<ForecastModel>{
        return tomorrowForecastData
    }
}