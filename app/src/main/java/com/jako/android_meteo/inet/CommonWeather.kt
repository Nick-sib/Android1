package com.jako.android_meteo.inet

import android.os.Handler
import android.util.Log
import com.google.gson.Gson
import com.jako.android_meteo.BuildConfig
import com.jako.android_meteo.model.Main
import com.jako.android_meteo.model.Weather
import com.jako.android_meteo.model.WeatherRequest
import com.jako.android_meteo.model.Wind
import com.jako.android_meteo.ui.main.CityData
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.MalformedURLException
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection


object CommonWeather {

    @JvmStatic
    private val errRequest = WeatherRequest(
        arrayOf(Weather("","")),
        Main(0f,0),
        Wind(0f),
        "Город не найден",
        0
    )

    private const val UNITS = "metric"
    private const val LANG = "ru"
    private const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?id=%s&units=$UNITS&lang=$LANG&appid=${BuildConfig.WEATHER_API_KEY}"

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
                val result = getLines(inBuf)
                //Log.d("myLOG", result)
                val gson = Gson()
                val weatherRequest = gson.fromJson(
                    result,
                    WeatherRequest::class.java
                )

                handler.post {
                    cityData.viewModel.setWeatherData(weatherRequest)
                }

            }
            catch (e: Exception) {
                Log.e("myLOG", "Fail connection", e)
                handler.post {
                    cityData.viewModel.setWeatherData(errRequest)
                }
                e.printStackTrace()
            }
            catch (e: MalformedURLException) {
                Log.e("myLOG", "Fail URI", e)
                handler.post{
                    cityData.viewModel.setWeatherData(errRequest)
                }
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