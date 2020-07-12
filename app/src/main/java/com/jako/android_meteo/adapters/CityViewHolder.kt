package com.jako.android_meteo.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import com.jako.android_meteo.model.WeatherData
import kotlinx.android.synthetic.main.select_city_item.view.*


class CityViewHolder (itemView: View, parent: ViewGroup, private val onItemListClick: OnItemListClick?) :
    RecyclerView.ViewHolder(itemView) {

    init {
        /*itemView.tv_CityLine.setOnClickListener {
            if (it != null ) onItemListClick?.onSelectItem((it as TextView).text.toString())
        }*/
//        itemView.setOnClickListener {
//            onItemListClick?.onSelectItem(weatherData)
//        }
    }


    fun bind(weatherData: WeatherData) {
        itemView.mcb_CityLine.text = weatherData.cityName
        itemView.mcb_CityLine.isChecked = weatherData.tmpCheck || weatherData.isCheck

        itemView.mcb_CityLine.setOnClickListener{
            weatherData.tmpCheck = (it as MaterialCheckBox).isChecked
        }

        itemView.setOnClickListener {
            onItemListClick?.onSelectItem(weatherData)
        }
    }

}
