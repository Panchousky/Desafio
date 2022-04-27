package com.example.desafio.domain

import com.example.desafio.data.GitRepositories
import com.example.desafio.data.model.PullRequestModel


class GetPullRequestUseCase {

    private val pulls = GitRepositories()
    suspend operator fun invoke(user:String, repo:String): List<PullRequestModel> = pulls.getAllPulls(user, repo)

}