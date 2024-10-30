package com.example.aidify.models

sealed class RequestState<out T> {
    data object Loading : RequestState<Nothing>()
    data class Success<out T>(val data: T) : RequestState<T>()
    data class Error(val message: String) : RequestState<Nothing>()
    data object Idle : RequestState<Nothing>()
}