package com.example.composetask.data.network

sealed class NetworkResponse<T>(
    val data: T? = null,
    val errorMessage: String? = null,
    val exception: Throwable? = null,
) {
    class Success<T>(data: T) : NetworkResponse<T>(data = data)
    class Error<T>(errorMessage: String? = "", exception: Throwable? = null) :
        NetworkResponse<T>(
            errorMessage = errorMessage,
            exception = exception
        )
}