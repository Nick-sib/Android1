package com.jako.android_meteo.model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jako.android_meteo.adapters.CityListAdapter
import java.text.SimpleDateFormat
import java.util.*


class WeatherViewModel: ViewModel() {

    val adapter: CityListAdapter = CityListAdapter()
    val weatherData = MutableLiveData<WeatherData>()


    fun setWeatherData(weatherRequest: WeatherRequest) {

        val today = Calendar.getInstance().time
        weatherData.value = adapter.setData(weatherRequest, SimpleDateFormat("EEEE").format(today).capitalize())
    }

    companion object {
        const val DEFAULT_ID = 1496747
    }
}