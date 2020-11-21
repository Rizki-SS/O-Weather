package com.example.weatherapp

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.model.ListForecast
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("android:iconUrl")
fun loadImage(view: ImageView, iconName:String? ) {
    val url="http://openweathermap.org/img/wn/"+iconName+"@2x.png"
    Picasso.get().load(url).into(view)
}

@BindingAdapter("android:setAdapter")
fun setAdapter(view: RecyclerView, list: List<ListForecast>? ) {
    view.adapter = list?.let { ForecastItemAdaptor(it) }
}


@BindingAdapter("android:unixTime","android:formatTime")
fun unixToUtc(view:TextView, unix:Int, format:String){
    //"EEE, dd MMM H:mm"
    //"H : mm"
    val dateFormat = SimpleDateFormat(format)
    val date = dateFormat.format(Date(unix.toLong() * 1000))
    view.text = date
}