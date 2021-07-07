package com.jako.android_meteo

import android.util.Log
import com.jako.android_meteo.ui.main.TAG

/**может не совсем безопасно но будет один глобальный объект */

object Singleton {

    init {
        //Toast.makeText(getContext(), "Singleton : Created", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Singleton : onCreate")
    }

    var clickCount = 0
    var isBlackThem = false//это не обязательно у Switch есть id состояние и так сохранится
}