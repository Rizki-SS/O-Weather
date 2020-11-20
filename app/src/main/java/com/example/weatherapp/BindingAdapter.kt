package com.example.weatherapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


@BindingAdapter("android:iconUrl")
fun loadImage(view: ImageView, iconName:String? ) {
    val url="http://openweathermap.org/img/wn/"+iconName+"@2x.png"
    Picasso.get().load(url).into(view)
}