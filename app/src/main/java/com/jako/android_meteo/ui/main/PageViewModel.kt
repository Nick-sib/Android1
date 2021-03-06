package com.jako.testtask_eastwind.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jako.android_meteo.R

class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
   // val text: LiveData<String> = Transformations.map(_index) { "Hello world from section: $it" }

    fun setIndex(index: Int) {
        _index.value = index
    }
}