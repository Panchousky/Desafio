package com.example.desafio.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafio.data.model.RepositoriesModel
import com.example.desafio.domain.GetRepositoresUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val repoModel = MutableLiveData<List<RepositoriesModel>>()
    val getRepositoresUseCase = GetRepositoresUseCase()


    fun onStart() {
        viewModelScope.launch {
            val result = getRepositoresUseCase()

            if (!result.isNullOrEmpty()) {
                repoModel.postValue(result!!)
            }
        }
    }

}