package com.jako.testtask_eastwind.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.jako.android_meteo.R
import com.jako.android_meteo.adapters.OnItemListClick
import com.jako.android_meteo.ui.main.TAG
import kotlinx.android.synthetic.main.data_city.*
import kotlinx.android.synthetic.main.data_city.view.*
import java.util.*


/**
 * A placeholder fragment containing a simple view.
 */
class CityData : Fragment(), OnItemListClick {

    private lateinit var pageViewModel: PageViewModel
    private val delmeData = DoubleArray(7)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 2)
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

       // pageViewModel.text.observe(this, Observer<String> {
          //  textView.setText(R.string.tab_text_1)
        //})
        return root
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

    override fun onSelectItem(title: String) {
        tv_CityName.text = title
    }


}