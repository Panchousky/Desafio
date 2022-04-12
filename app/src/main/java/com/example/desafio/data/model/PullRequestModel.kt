package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName

data class PullRequestModel(@SerializedName("title") var title: String,
                            @SerializedName("body") var body: String,
                            @SerializedName("user") var userModel: UserModel,
                            @SerializedName("type") var sobreNmbre: String)