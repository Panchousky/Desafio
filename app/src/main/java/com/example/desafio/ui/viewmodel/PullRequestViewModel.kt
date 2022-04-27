package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.PullRequestModel
import com.example.desafio.domain.GetPullRequestUseCase
import kotlinx.coroutines.launch

class PullRequestViewModel : ViewModel() {
    val pullModel = MutableLiveData<List<PullRequestModel>>()
    val getPullRequestUseCase = GetPullRequestUseCase()


    fun getPullRequestList(user:String, repo:String) {
        viewModelScope.launch {
            val result = getPullRequestUseCase(user, repo)

            if (!result.isNullOrEmpty()) {
               pullModel.postValue(result)
            }
        }
    }

}