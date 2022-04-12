package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(@SerializedName("avatar_url") var name: String,
                 @SerializedName("login")var login:String)