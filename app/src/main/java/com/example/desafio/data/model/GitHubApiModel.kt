package com.example.desafio.data.model

import com.google.gson.annotations.SerializedName


data class RecyclerList(@SerializedName("items") val items: ArrayList<RepositoriesModel>)

