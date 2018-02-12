package com.roobics.chuck.utils

import com.roobics.chuck.utils.Resource.Status.*


/**
 * A generic class that holds a value with its loading status.
 * @param <T>
</T> */
class Resource<T> private constructor(val status: Status, val data: T?, val exception: Throwable?) {
    enum class Status {
        SUCCESS, ERROR, LOADING
    }
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(SUCCESS, data, null)
        }
        fun <T> error(exception: Throwable?): Resource<T> {
            return Resource(ERROR, null, exception)
        }
        fun <T> loading(data: T?): Resource<T> {
            return Resource(LOADING, data, null)
        }
    }
}