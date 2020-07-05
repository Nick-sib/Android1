package com.jako.android_meteo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import androidx.recyclerview.widget.RecyclerView
import com.jako.android_meteo.R


class CityListAdapter(private var workList: List<String>):
    RecyclerView.Adapter<CityViewHolder>() {

    private val fullList: List<String> = ArrayList(workList)

    var onItemListClickListener: OnItemListClick? = null

    fun applyFilter(value: String) {
        workList =
            if (value.length > 1)
                fullList.filter {
                    it.toLowerCase().contains(value.toLowerCase())
            } else ArrayList(fullList)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CityViewHolder(inflater.inflate(R.layout.select_city_item, parent, false), parent, onItemListClickListener)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(workList[position])
    }

    override fun getItemCount(): Int = workList.size

}