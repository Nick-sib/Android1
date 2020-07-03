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

        /*val exampleFilter = object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filteredList: MutableList<String> = ArrayList()

                if (constraint == null || constraint.length == 0) {
                    filteredList.addAll(fullList)
                } else {
                    val filterPattern =
                        constraint.toString().toLowerCase().trim { it <= ' ' }
                    for (item in fullList) {
                        if (item.getText2().toLowerCase().contains(filterPattern)) {
                            filteredList.add(item)
                        }
                    }
                }
                val results = FilterResults()
                results.values = filteredList
                return results
            }

            override fun publishResults(
                constraint: CharSequence,
                results: FilterResults
            ) {
                workList.clear()
                workList.addAll(results.values as List<*>)
                notifyDataSetChanged()
            }
        }*/

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