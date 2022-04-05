package com.example.desafio


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface Interface {
    @GET("search/repositories?q=language:Java&sort=stars")
   fun getDataFromAPI():Call<RecyclerList>


    @GET
    fun getPulls(@Url url: String): Call<RepoPullsList>

}