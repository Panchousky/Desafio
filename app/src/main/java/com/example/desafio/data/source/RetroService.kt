package com.example.desafio.data.source

import com.example.desafio.core.RetrofitHelper
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.data.model.RepositoriesModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class RetroService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getRepositories(): List<RepositoriesModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RetrofitInstance::class.java).getRepositories()
            response.body()?.items ?: emptyList()

        }
    }

    suspend fun getPulls(user: String, repo: String): List<PullRequestModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(RetrofitInstance::class.java).getPullRequests(user, repo)
            response.body() ?: emptyList()
        }

    }
}