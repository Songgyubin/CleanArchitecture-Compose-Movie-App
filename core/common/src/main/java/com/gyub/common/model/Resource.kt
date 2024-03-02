package com.gyub.common.model

/**
 * API 통신 결과(Response) Data를 적재하는 Wrapper Class
 *
 * @author   Gyub
 * @created  2024/03/02
 */
sealed class Resource<out T> {

    companion object {
        const val MESSAGE = "success"
    }

    data class Success<out T>(
        val value: T,
        val message: String = MESSAGE,
    ) : Resource<T>()

    data class Failure(
        val statusCode: Int,
        val message: String,
    ) : Resource<Nothing>()

    data class ErrorException(val exception: Exception) : Resource<Nothing>()

    object Loading : Resource<Nothing>()
    object Error : Resource<Nothing>()
    object Empty : Resource<Nothing>()
}

/**
 * Object Mapper
 *
 * @param T Input Resource
 * @param V Output Entity
 * @param callback Entity Converter High Order Function
 * @return Resource<V>
 */
inline fun <reified T, reified V> Resource<T>.convertIfSuccess(callback: (value: T) -> V): Resource<V> {
    return when (this) {
        is Resource.Error -> Resource.Error
        is Resource.Failure -> Resource.Failure(statusCode, message)
        is Resource.Loading -> Resource.Loading
        is Resource.Success -> Resource.Success(callback(value), message)
        is Resource.Empty -> Resource.Empty
        is Resource.ErrorException -> Resource.ErrorException(exception)
    }
}

/**
 * List Mapper
 *
 * @param T Input Resource
 * @param V Output List
 * @param block Entity List High Order Function
 * @return List<V>
 */
inline fun <reified T, reified V> Resource<T>.convertListIfSuccess(block: (value: T) -> List<V>): List<V> {
    return when (this) {
        is Resource.Success -> block.invoke(value)
        Resource.Error -> emptyList()
        else -> emptyList()
    }
}