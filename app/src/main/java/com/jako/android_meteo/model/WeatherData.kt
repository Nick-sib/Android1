package com.jako.android_meteo.model

import java.text.SimpleDateFormat
import java.util.*

class WeatherData(val cityName: String, val id: Int) {
    var tmpCheck = false
    var isCheck = false
    var isLoaded = false
    var dayWeek = SimpleDateFormat("EEEE").format(Calendar.getInstance().time).capitalize()
    var overcast = "облачность"
    var temp = 0
    var humidity = 0 //Влажность
    var wind = 0f
}