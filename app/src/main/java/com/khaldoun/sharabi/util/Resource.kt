package com.khaldoun.sharabi.util

sealed class Resource<T>( //can receive any data type because of <T> generic
    val data: T?=null,
    val message: String? =null
){
    class Success<T>(data: T): Resource<T>(data)
    class Error<T>(message: String): Resource<T>(message = message)
    class Loading<T>: Resource<T>()
}
