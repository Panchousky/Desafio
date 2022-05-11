package com.example.desafio.data.model

class LiveDataModels {

    sealed class Result<T> {
        data class OnSuccess<T>(val value: T) : Result<T>()
        data class OnError<T>(val throwable: Throwable) : Result<T>()
        class OnLoading<T> : Result<T>()
    }

}