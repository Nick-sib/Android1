package com.jako.android_meteo.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.radiobutton.MaterialRadioButton
import com.jako.android_meteo.R
import kotlinx.android.synthetic.main.select_city_item.view.*

/*class CityViewHolder (inflater: LayoutInflater, parent: ViewGroup, onItemListClick: OnItemListClick?) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.select_city_item, parent, false)) {*/

class CityViewHolder (itemView: View, parent: ViewGroup, onItemListClick: OnItemListClick?) :
    RecyclerView.ViewHolder(itemView) {

    init {
        itemView.tv_CityLine.setOnClickListener {
            if (it != null ) onItemListClick?.onSelectItem((it as TextView).text.toString())
        }
        /*itemView.setOnClickListener {
            onItemListClick?.onSelectItem(itemView.findViewById<MaterialCheckBox>(R.id.tv_CityLine).text.toString())
        }*/
    }


    fun bind(city: String) {
        itemView.tv_CityLine.text = city
    }

}
