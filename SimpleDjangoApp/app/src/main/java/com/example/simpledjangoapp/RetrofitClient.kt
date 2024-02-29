package com.example.simpledjangoapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.101.8:8000/" // for real android device
//    private const val BASE_URL = "http://10.0.2.2:8000/" //for emulator

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiServices = retrofit.create(ApiServices::class.java)
}