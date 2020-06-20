package com.jako.android_meteo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.city_select.*

const val TAG = "myLOG"
const val MESSAGE_CHECKBOX = "com.jako.android_meteo.checkBox"

class SelectCity: AppCompatActivity() {

    val ClassName = "SelectCity.class"

    var instanceState = "Первый запуск!"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_select)

        if (savedInstanceState != null) {
            instanceState = "Повторный запуск!"
            checkBox.isChecked = savedInstanceState!!.getBoolean(MESSAGE_CHECKBOX, false)
        }


        tv_delme.text = "${Singleton.clickCount}"
        Toast.makeText(this, "$instanceState - $ClassName : onCreate", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$instanceState - $ClassName : onCreate")
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "$ClassName : onStart", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onStart")
    }


    override fun onResume() {
        super.onResume()

        Toast.makeText(this, "$ClassName : onResume", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onResume")
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "$ClassName : onPause", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "$ClassName : onDestroy", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean(MESSAGE_CHECKBOX, checkBox.isChecked)

        Toast.makeText(this, "$ClassName : onSaveInstanceState", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        checkBox.isChecked = savedInstanceState.getBoolean(MESSAGE_CHECKBOX, false)

        tv_delme.text = "${Singleton.clickCount}"
        s_black_them.isChecked = Singleton.isBlackThem

        Toast.makeText(this, "$ClassName : onRestoreInstanceState", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onRestoreInstanceState")
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "$ClassName : onStop", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "$ClassName : onRestart", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onRestart")
    }


    fun delme_fun(view: View) {
        when (view.id) {
            R.id.b_delme -> tv_delme.text = "${++Singleton.clickCount}"
            R.id.s_black_them -> Singleton.isBlackThem = s_black_them.isChecked
        }

    }


}