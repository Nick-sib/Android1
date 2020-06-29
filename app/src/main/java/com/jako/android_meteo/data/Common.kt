package com.jako.android_meteo.data


object Common {
    private val BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=Novosibirsk,ru&appid=-=API_KEY=-"

    val retrofitService: RetrofitService
    get() = RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
}