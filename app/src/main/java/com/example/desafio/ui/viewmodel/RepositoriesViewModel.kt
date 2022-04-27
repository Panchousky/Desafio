package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.domain.GetRepositoriesUseCase
import kotlinx.coroutines.launch

class RepositoriesViewModel : ViewModel() {
    val repoModel = MutableLiveData<List<RepositoriesModel>>()
    val getRepositoriesUseCase = GetRepositoriesUseCase()


    fun getRepositoriesList() {
        viewModelScope.launch {
            val result = getRepositoriesUseCase()

            if (!result.isNullOrEmpty()) {
                repoModel.postValue(result)
            }
        }
    }

}