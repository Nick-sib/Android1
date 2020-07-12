package com.jako.android_meteo.inet

import android.app.Activity
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.jako.android_meteo.MainActivity
import com.jako.android_meteo.model.Main
import com.jako.android_meteo.model.Weather
import com.jako.android_meteo.model.WeatherRequest
import com.jako.android_meteo.model.Wind
import com.jako.android_meteo.ui.main.TAG
import com.jako.testtask_eastwind.ui.main.CityData
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection
import kotlin.math.log


object common_weather {

    val errRequest = WeatherRequest(
        arrayOf(Weather("")),
        Main(0f,0),
        Wind(0f),
        "Город не найден",
        0
    )

    val API_KEY = ""
    val UNITS = "metric"
    //val CITY_ID = 1496747
    val LANG = "ru"
    val WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?id=%s&units=$UNITS&lang=$LANG&appid=$API_KEY"

    //val handler = Handler() // Запоминаем основной поток

    fun getData(cityData: CityData, handler: Handler, CITY_ID: Int) {
        val uri = URL(String.format(WEATHER_URL, CITY_ID))

        Thread(Runnable {
            try {
                val urlConnection =
                    (uri.openConnection() as HttpsURLConnection).apply {
                        requestMethod = "GET"
                        connectTimeout = 10_000
                    }
                val inBuf = BufferedReader(InputStreamReader(urlConnection.inputStream))
                var result = getLines(inBuf)
                //Log.d("myLOG", result)
                val gson = Gson()
                val weatherRequest = gson.fromJson(
                    result,
                    WeatherRequest::class.java
                )

                handler.post(Runnable {
                    cityData.viewModel.setWeatherData(weatherRequest)
                })


                //Log.d("myLOG", weatherRequest.toString())
            }
            catch (e: Exception) {
                Log.e(TAG, "Fail connection", e)
                handler.post(Runnable {
                    cityData.viewModel.setWeatherData(errRequest)
                })
                e.printStackTrace()
            }
            catch (e: MalformedURLException) {
                Log.e(TAG, "Fail URI", e)
                handler.post(Runnable {
                    cityData.viewModel.setWeatherData(errRequest)
                })
                e.printStackTrace()
            }

            finally {

            }

        }).start()

    }

    private fun getLines(inBuf: BufferedReader): String {
        return inBuf.lines().collect(Collectors.joining("\n"))
    }


}