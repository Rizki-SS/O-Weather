package com.example.weatherapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.ListItemBinding
import com.example.weatherapp.model.ListForecast


class ForecastItemAdaptor(
    private var data: List<ListForecast>
) : RecyclerView.Adapter<ForecastItemAdaptor.ItemViewHolder>() {

    class ItemViewHolder(
        val listItemBinding: ListItemBinding
    ) : RecyclerView.ViewHolder(listItemBinding.root)

    override fun getItemCount() = data.size

    fun updateData(data:List<ListForecast>){
        this.data = data
    }

    // untuk membuat setiap item recyclerview berdasarkan jumlah data yang dimasukkan ke dalam adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ItemViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item, parent, false)
    )

    // untuk memasukkan atau set data ke dalam view
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
//        Log.d("String",data.get(position).toString())
        holder.listItemBinding.data = data.get(position)
    }
}