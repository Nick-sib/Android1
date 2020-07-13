package com.jako.android_meteo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jako.android_meteo.ui.main.CityData
import com.jako.android_meteo.ui.main.SelectCity


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CityData.newInstance(position)
            1 -> SelectCity.newInstance(position)
            else -> CityData.newInstance(position)
        }
    }

    override fun getCount(): Int {
        return 2
    }
}