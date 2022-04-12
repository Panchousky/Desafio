package com.example.desafio.domain

import com.example.desafio.data.GitRepositories
import com.example.desafio.data.model.RepositoriesModel

class GetRepositoresUseCase {

    private val repositories = GitRepositories()
    suspend operator fun invoke(): List<RepositoriesModel>? = repositories.getAllRepositores()

}