package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.LiveDataModels
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.domain.GetPullRequestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PullRequestViewModel : ViewModel() {
    val pullModel = MutableLiveData<LiveDataModels.Result<List<PullRequestModel>>>()
    val getPullRequestUseCase = GetPullRequestUseCase()

    //integrar inyeccion de dependencias (Koin,Hilt o Dagger)
    fun getPullRequestList(user: String, repo: String) {
        viewModelScope.launch(Dispatchers.Main) {
            pullModel.postValue(LiveDataModels.Result.OnLoading())
            runCatching {
                withContext(Dispatchers.IO){
                    getPullRequestUseCase(user, repo)
                }
            }.onSuccess { result ->
                val answer = LiveDataModels.Result.OnSuccess(result)
                pullModel.postValue(answer)
            }.onFailure { e ->
                pullModel.postValue(LiveDataModels.Result.OnError(e))
            }
        }
    }

}