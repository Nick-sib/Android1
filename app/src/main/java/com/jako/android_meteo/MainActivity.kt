package com.jako.android_meteo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jako.android_meteo.inet.common_weather
import com.jako.testtask_eastwind.ui.main.CityData
import com.jako.testtask_eastwind.ui.main.WeatherViewModel
import com.jako.testtask_eastwind.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java).also {
            it.adapter.setLists(resources.getStringArray(R.array.citys_array).toList(), it.DEFAULT_ID)
        }

        view_pager.adapter = SectionsPagerAdapter(this, supportFragmentManager)

    }

    private fun logSteps(text: String) {
        //Toast.makeText(this, "$ClassName : $text", Toast.LENGTH_SHORT).show()
        Log.d(com.jako.android_meteo.ui.main.TAG, text)
    }

    fun button_click(view: View) {
        when (view.id) {
            R.id.mb_cancel -> {
                viewModel.adapter.cancelCheck()
                view_pager.currentItem = 0}
            R.id.mb_apply -> {
                viewModel.adapter.applyCheck()
                (supportFragmentManager.fragments[0] as CityData).onSelectItem(viewModel.adapter.getFirst())

                Snackbar.make(view, "Сохранить как списко по умолчанию?", Snackbar.LENGTH_LONG)
                .setAction("Сохранить") {
                    Log.d(com.jako.android_meteo.ui.main.TAG, "При перезагрузки апп раставить чекбоксы")
                }.show()
                view_pager.currentItem = 0}
            else -> Log.d(com.jako.android_meteo.ui.main.TAG, "button_click: ")
        }

    }
}