package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class RepositoriesModel(@SerializedName("full_name") var full_name: String,
                             @SerializedName("description") var description: String,
                             @SerializedName("stargazers_count") var stargazers_count: String,
                             @SerializedName("forks_count") var forks_count: String,
                             @SerializedName("name") var name: String,
                             @SerializedName("owner") var userModel: UserModel
)