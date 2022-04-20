package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class PullRequestModel(
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("user") val userModel: UserModel,
    @SerializedName("type") val sobreNmbre: String
)