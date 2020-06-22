package com.jako.android_meteo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.city_select.*


class MainActivity : AppCompatActivity() {
    val ClassName = "MainActivity.class"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_Setting.setOnClickListener {
                startActivity(Intent(this, SelectCity::class.java).apply{
                    putExtra(MESSAGE_CHECKBOX, true)
                })}



        Toast.makeText(this, "$ClassName : onCreate", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "$ClassName : onCreate")
    }
}