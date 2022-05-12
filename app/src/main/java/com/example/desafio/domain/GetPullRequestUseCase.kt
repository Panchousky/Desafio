package com.example.desafio.domain

import com.example.desafio.data.GitRepositories
import com.example.desafio.data.model.PullRequestModel
import kotlinx.coroutines.delay


class GetPullRequestUseCase {

    private val pulls = GitRepositories()
    suspend operator fun invoke(user:String, repo:String): List<PullRequestModel>{
        delay(10000)
        return pulls.getAllPulls(user, repo)
    }

}