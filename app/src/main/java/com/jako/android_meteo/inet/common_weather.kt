package com.jako.android_meteo.inet


import android.content.res.Resources
import android.util.Log
import com.jako.android_meteo.R
import com.jako.android_meteo.ui.main.TAG

object common_weather {

    lateinit var WEATHER_URL: String


    fun login(v: Resources) {
        WEATHER_URL =
        "https://api.openweathermap.org/data/2.5/weather?lat=55.75&lon=37.62&appid=${v.getString(R.string.weather_api_key)}"
        log()
    }

    fun log() {
        Log.d(TAG, WEATHER_URL)
    }
}