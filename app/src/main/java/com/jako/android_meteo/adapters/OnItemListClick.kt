package com.jako.android_meteo.adapters

import com.jako.android_meteo.model.WeatherData

interface OnItemListClick {
    fun onSelectItem(weatherData: WeatherData)
}