package com.jako.android_meteo.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.select_city_item.view.*


class CityViewHolder (itemView: View, parent: ViewGroup, onItemListClick: OnItemListClick?) :
    RecyclerView.ViewHolder(itemView) {

    init {
        /*itemView.tv_CityLine.setOnClickListener {
            if (it != null ) onItemListClick?.onSelectItem((it as TextView).text.toString())
        }*/
        /*itemView.setOnClickListener {
            onItemListClick?.onSelectItem(itemView.findViewById<MaterialCheckBox>(R.id.tv_CityLine).text.toString())
        }*/
    }


    fun bind(city: String) {
        itemView.mcb_CityLine.text = city
    }

}
