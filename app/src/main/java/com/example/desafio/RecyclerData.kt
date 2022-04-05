package com.example.desafio

import com.google.gson.annotations.SerializedName


data class RecyclerList(@SerializedName("items") val items: ArrayList<RecyclerData>)

data class RecyclerData(@SerializedName("full_name") var full_name: String,
                            @SerializedName("description") var description: String,
                            @SerializedName("stargazers_count") var stargazers_count: String,
                            @SerializedName("forks_count") var forks_count: String,
                            @SerializedName("name") var name: String,
                            @SerializedName("owner") var owner: Owner)

//, val owner: Owner)

data class Owner(  @SerializedName("avatar_url") var name: String,
                   @SerializedName("login")var login:String)

data class RepositoryPulls(@SerializedName("title") var title: String,
                           @SerializedName("body") var body: String,
                           @SerializedName("user") var owner: Owner,
                           @SerializedName("type") var sobreNmbre: String)

data class RepoPullsList(@SerializedName("type") val Pulls: ArrayList<RepositoryPulls>)

