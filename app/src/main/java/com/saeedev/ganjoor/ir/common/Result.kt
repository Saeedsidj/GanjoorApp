package com.saeedev.ganjoor.ir.common

sealed class Result<out T> {

    object Loading : Result<Nothing>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable, var showDialog: Boolean = false) : Result<Nothing>()
}

inline fun <R> Result<R>.onSuccess(action: (R) -> Unit): Result<R> {
    if (this is Result.Success) {
        action(data)
    }
    return this
}

inline fun <R> Result<R>.onFailure(action: () -> Unit): Result<R> {
    if (this is Result.Error) {
        action()
    }
    return this
}
