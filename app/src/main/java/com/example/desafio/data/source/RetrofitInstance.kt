package com.example.desafio.data.source


import com.example.desafio.data.model.RecyclerList
import com.example.desafio.data.model.RepoPullsList
import com.example.desafio.data.model.RepositoriesModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitInstance {

    /*@GET("search/repositories?q=language:Java&sort=stars")
   fun getDataFromAPI():Call<RecyclerList>


    @GET
    fun getPulls(@Url url: String): Call<RepoPullsList>
*/
    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getRepositories():Response<RecyclerList>


}