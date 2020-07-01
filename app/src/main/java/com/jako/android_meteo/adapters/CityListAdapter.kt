package com.jako.android_meteo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jako.android_meteo.R

class CityListAdapter(private val list: Array<String>):
    RecyclerView.Adapter<CityViewHolder>() {

    var onItemListClickListener: OnItemListClick? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CityViewHolder(inflater.inflate(R.layout.select_city_item, parent, false), parent, onItemListClickListener)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}