package com.saeedev.ganjoor.ir.common

import okio.IOException
import retrofit2.Response

suspend fun <T> safeApi(
    response: suspend () -> Response<T>
): Result<T> {
    return try {
        if (response().isSuccessful) {
            response().body()?.let { Result.Success(it) }
                ?: Result.Loading
        } else {
            Result.Error(IOException())
        }
    } catch (e: Throwable) {
        Result.Error(e)
    }
}
