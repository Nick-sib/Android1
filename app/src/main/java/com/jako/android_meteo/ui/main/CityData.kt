package com.jako.testtask_eastwind.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jako.android_meteo.R
import com.jako.android_meteo.adapters.OnItemListClick
import com.jako.android_meteo.inet.common_weather
import com.jako.android_meteo.model.WeatherData
import kotlinx.android.synthetic.main.data_city.*
import kotlinx.android.synthetic.main.data_city.view.*
import java.util.*


/**
 * A placeholder fragment containing a simple view.
 */
class CityData : Fragment(), OnItemListClick {

    lateinit var viewModel: WeatherViewModel

    private val delmeData = DoubleArray(7)
    private lateinit var s_humidity: String
    private lateinit var s_wind: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(activity!!).get(WeatherViewModel::class.java)

        s_humidity = resources.getString(R.string.t_humidity)
        s_wind = resources.getString(R.string.t_wind)

        viewModel.weatherData.observe(
            this,
            androidx.lifecycle.Observer {
                compliteData(it)
            })

        if (savedInstanceState == null) {
            common_weather.getData(this, Handler(), viewModel.DEFAULT_ID)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.data_city, container, false)

        for (i in delmeData.indices) {
            delmeData[i] = 29 + (5 * random.nextDouble() - 3)
        }
        root.linechart.setChartData(delmeData, "Недельный прогноз")

        val listner = View.OnClickListener{
            onSelectItem(viewModel.adapter.getNext())
        }

        root.tv_CityName.setOnClickListener(listner)
        root.setOnClickListener(listner)

        return root
    }

    fun compliteData(data: WeatherData) {
        tv_CityName.text = data.cityName
        tv_DayOfWeek.text = data.dayWeek
        tv_Cloudiness.text = data.overcast
        tv_Temperature.text = data.temp.toString()
        tv_Humidity.text = String.format(s_humidity, data.humidity, "%")
        tv_Wind.text = String.format(s_wind, data.wind)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"
        private val random = Random()

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): CityData {
            return CityData().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onSelectItem(weatherData: WeatherData) {
        if (weatherData.isLoaded) {
            compliteData(weatherData)
        } else common_weather.getData(this, Handler(), weatherData.id)

    }

}