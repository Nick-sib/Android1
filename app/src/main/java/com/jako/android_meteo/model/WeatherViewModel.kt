package com.jako.testtask_eastwind.ui.main


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jako.android_meteo.adapters.CityListAdapter
import com.jako.android_meteo.model.WeatherData
import com.jako.android_meteo.model.WeatherRequest
import java.text.SimpleDateFormat
import java.util.*


class WeatherViewModel: ViewModel() {

    val DEFAULT_ID = 1496747

    val adapter: CityListAdapter = CityListAdapter()
    val weatherData = MutableLiveData<WeatherData>()


    fun setWeatherData(weatherRequest: WeatherRequest) {

        val today = Calendar.getInstance().time
        weatherData.value = adapter.setData(weatherRequest, SimpleDateFormat("EEEE").format(today).capitalize())
    }

}