package com.jako.android_meteo.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jako.android_meteo.R
import com.jako.android_meteo.Singleton
import com.jako.android_meteo.adapters.CityListAdapter
import com.jako.testtask_eastwind.ui.main.CityData
import kotlinx.android.synthetic.main.city_select.*
import kotlinx.android.synthetic.main.city_select.view.*


const val TAG = "myLOG"
const val MESSAGE_CHECKBOX = "com.jako.android_meteo.checkBox"

class SelectCity: Fragment() {



    /*val CITY_ARRAY_NAME = Array(CITY_ARRAY_INDEX.size)
    {i -> context?.resources?.getString(CITY_ARRAY_INDEX[i]) }*/

    val ClassName = "SelectCity.class"

    var instanceState = "Первый запуск!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.city_select)
/*
        if (savedInstanceState != null) {
            instanceState = "Повторный запуск!"
        } else
            checkBox.isChecked = intent.getBooleanExtra(MESSAGE_CHECKBOX, false)*/


        logSteps("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.city_select, container, false)
        //val textView: TextView = root.findViewById(R.id.section_label)
        // pageViewModel.text.observe(this, Observer<String> {
        //textView.setText(R.string.tab_text_1)
        //})

        root.rv_citys.adapter =
            CityListAdapter(
                    resources.getStringArray(R.array.citys_array)
                ).apply {

                    onItemListClickListener = parentFragmentManager.fragments[0] as CityData
                }

        root.b_delme.setOnClickListener {
            tv_delme.text = "${++Singleton.clickCount}"
        }

        root.tv_delme.text = "${Singleton.clickCount}"

        return root
    }


    override fun onStart() {
        super.onStart()

        logSteps("onStart")
    }


    override fun onResume() {
        super.onResume()

        logSteps("onResume")
    }

    override fun onPause() {
        super.onPause()

        logSteps("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        logSteps("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean(MESSAGE_CHECKBOX, checkBox.isChecked)

        logSteps("onSaveInstanceState")
    }



    override fun onStop() {
        super.onStop()

        logSteps("onStop")
    }


    /*override fun onClick(view: View) {
        when (view.id) {
            R.id.b_delme -> tv_delme.text = "${++Singleton.clickCount}"
            R.id.s_black_them -> Singleton.isBlackThem = s_black_them.isChecked
        }
    }*/



    private fun logSteps(text: String) {
        //Toast.makeText(this, "$instanceState - $ClassName : $text", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$instanceState - $ClassName : $text")
    }


    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): SelectCity {
            return SelectCity().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }



}