package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class RepositoriesModel(
    @SerializedName("full_name") val full_name: String,
    @SerializedName("description") val description: String,
    @SerializedName("stargazers_count") val stargazers_count: String,
    @SerializedName("forks_count") val forks_count: String,
    @SerializedName("name") val name: String,
    @SerializedName("owner") val userModel: UserModel
)