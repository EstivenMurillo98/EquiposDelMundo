package com.parcialfinal.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getRetrofitInstance(): Retrofit {
        return retrofit
    }
}