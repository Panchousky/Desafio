package com.example.desafio.data.source


import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.data.model.RecyclerList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitInstance {

    /*@GET("search/repositories?q=language:Java&sort=stars")
   fun getDataFromAPI():Call<RecyclerList>



*/
    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getRepositories():Response<RecyclerList>

    @GET("repos/{user}/{repo}/pulls")
    suspend fun getPullRequests(
        @Path("user") user:String,
        @Path("repo") repo:String)
            : Response<List<PullRequestModel>>

}