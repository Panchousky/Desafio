package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("avatar_url") val name: String,
    @SerializedName("login") val login: String
)