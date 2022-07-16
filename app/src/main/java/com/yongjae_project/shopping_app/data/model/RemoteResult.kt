package com.yongjae_project.shopping_app.data.model

sealed class RemoteResult<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : RemoteResult<T>(data)
    class Loading<T>(data: T? = null) : RemoteResult<T>(data)
    class Error<T>(message: String, data: T? = null) : RemoteResult<T>(data, message)
}
