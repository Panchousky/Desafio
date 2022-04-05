package com.example.desafio

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Instance {


    companion object{
        val baseURL = "https://api.github.com/search/Java&sort=stars"

        fun getRetro():Retrofit{

            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}