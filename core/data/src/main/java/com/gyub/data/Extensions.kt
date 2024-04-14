package com.gyub.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.ToNumberPolicy
import com.google.gson.reflect.TypeToken

/**
 * Data Layer에서 사용되는 확장 함수
 *
 * @author   Gyub
 * @created  2024/03/05
 */

val gson: Gson = GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create()

/**
 * convert a data class to a map
 *
 * @param T Data Class
 * @return Map
 */
fun <T> T.serializeToMap(): Map<String, Any> {
    return convert()
}

/**
 * convert an object of type I to type O
 *
 * @param I Input Object
 * @param O Output Object
 * @return Output Object
 */
inline fun <I, reified O> I.convert(): O {
    val json = gson.toJson(this)
    return gson.fromJson(json, object : TypeToken<O>() {}.type)
}