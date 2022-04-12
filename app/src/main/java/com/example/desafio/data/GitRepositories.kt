package com.example.desafio.data

import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.data.source.RetroService

class GitRepositories {

    private val retroService = RetroService()

    suspend fun getAllRepositores():List<RepositoriesModel>{
        val response = retroService.getRepositories()
        return response
    }

    suspend fun getAllPulls(user:String, repo:String):List<PullRequestModel>{
        val response = retroService.getPulls(user, repo)
        return response
    }
}