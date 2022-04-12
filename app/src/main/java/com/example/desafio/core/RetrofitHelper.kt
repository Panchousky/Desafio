package com.example.desafio.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")//Java&sort=stars
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}