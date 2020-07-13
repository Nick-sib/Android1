package com.jako.android_meteo

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.BuildCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.jako.android_meteo.ui.main.CityData
import com.jako.android_meteo.adapters.SectionsPagerAdapter
import com.jako.android_meteo.model.WeatherViewModel
import com.jako.android_meteo.model.WeatherViewModel.Companion.DEFAULT_ID
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.attribute.AclEntry


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: WeatherViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java).also {
            it.adapter.setLists(resources.getStringArray(R.array.citys_array).toList(), DEFAULT_ID)
        }

        view_pager.adapter = SectionsPagerAdapter(supportFragmentManager)

    }

    fun buttonClick(view: View) {
        when (view.id) {
            R.id.mb_cancel -> {
                viewModel.adapter.cancelCheck()
                view_pager.currentItem = 0}
            R.id.mb_apply -> {
                viewModel.adapter.applyCheck()
                (supportFragmentManager.fragments[0] as CityData).onSelectItem(viewModel.adapter.getFirst())

                Snackbar.make(view, "Сохранить как списко по умолчанию?", Snackbar.LENGTH_LONG)
                .setAction("Сохранить") {
                    Log.d("myLOG", "При перезагрузки апп раставить чекбоксы")
                }.show()
                view_pager.currentItem = 0}
            else -> Log.d("myLOG", "button_click: ")
        }

    }
}