package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.LiveDataModels
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.domain.GetPullRequestUseCase
import kotlinx.coroutines.launch

class PullRequestViewModel : ViewModel() {
    val pullModel = MutableLiveData<LiveDataModels.Result<List<PullRequestModel>>>()
    val getPullRequestUseCase = GetPullRequestUseCase()
    //val loadingData = MutableLiveData<Boolean>()


    // integrar sealed class, integrar un solo live data por operador.
    fun getPullRequestList(user: String, repo: String) {

        pullModel.postValue(LiveDataModels.Result.OnLoading())

        viewModelScope.launch {
           // loadingData.postValue(true)
            runCatching {
                getPullRequestUseCase(user, repo)
            }.onSuccess { result ->
                val answer = LiveDataModels.Result.OnSuccess(result)
                pullModel.postValue(answer)
            }.onFailure { e ->
                pullModel.postValue(LiveDataModels.Result.OnError(e))
            }

        }
    }

}