package com.example.desafio.data

import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.data.source.RetroService

class GitRepositories {

    private val retroService = RetroService()

    suspend fun getAllRepositories(): List<RepositoriesModel> {
        return retroService.getRepositories()
    }

    suspend fun getAllPulls(user: String, repo: String): List<PullRequestModel> {
        return retroService.getPulls(user, repo)
    }
}