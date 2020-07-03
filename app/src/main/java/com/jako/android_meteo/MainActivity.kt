package com.jako.android_meteo

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.jako.testtask_eastwind.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val ClassName = "MainActivity.class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = SectionsPagerAdapter(this, supportFragmentManager)


        /*b_Setting.setOnClickListener {
                startActivity(Intent(this, SelectCity::class.java).apply{
                    putExtra(MESSAGE_CHECKBOX, true)
                })}*/




        logSteps("onCreate")
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

        logSteps("onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        logSteps("onRestoreInstanceState")
    }

    override fun onStop() {
        super.onStop()

        logSteps("onStop")
    }

    override fun onRestart() {
        super.onRestart()

        logSteps("onRestart")
    }


    private fun logSteps(text: String) {
        //Toast.makeText(this, "$ClassName : $text", Toast.LENGTH_SHORT).show()
        Log.d(com.jako.android_meteo.ui.main.TAG, "$ClassName : $text")
    }
}