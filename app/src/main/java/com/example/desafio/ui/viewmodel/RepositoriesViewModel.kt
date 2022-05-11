package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.LiveDataModels
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.domain.GetRepositoriesUseCase
import kotlinx.coroutines.launch

class RepositoriesViewModel : ViewModel() {
    val repoModel = MutableLiveData<LiveDataModels.Result<List<RepositoriesModel>>>()
    val getRepositoriesUseCase = GetRepositoriesUseCase()


    fun getRepositoriesList() {
        viewModelScope.launch {
            repoModel.postValue(LiveDataModels.Result.OnLoading())
            runCatching {
                getRepositoriesUseCase()
            }.onSuccess { result ->
                val answer = LiveDataModels.Result.OnSuccess(result)
                repoModel.postValue(answer)
            }.onFailure { e ->
                repoModel.postValue(LiveDataModels.Result.OnError(e))
            }
        }
    }

}