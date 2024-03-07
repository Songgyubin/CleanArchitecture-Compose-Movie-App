package com.gyub.network.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.gyub.core.network.BuildConfig.API_KEY
import com.gyub.network.const.Http
import okhttp3.Interceptor

/**
 *
 *
 * @author   Gyub
 * @created  2024/03/02
 */
object NetworkUtil {
    /**
     * Pretty Log
     *
     * @param text json string
     * @return 정렬된 Json Data
     */
    fun getPrettyLogs(text: String?): String {
        text ?: return ""

        return try {
            val jsonParser = JsonParser()
            val jsonElement = jsonParser.parse(text)

            val gson: Gson = GsonBuilder().setPrettyPrinting().create()
            gson.toJson(jsonElement)
        } catch (e: Throwable) {
            text
        }
    }

    /**
     * 헤더 세팅
     *
     * @return
     */
    fun createHeader() =
        Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val builder = original.newBuilder().apply {
                getHeaders().forEach { (key, value) -> header(key, value) }
            }
            chain.proceed(builder.build())
        }

    /**
     * 내부 저장소에 저장되어 있는 정보 Header 취합
     *
     * @return
     */
    private fun getHeaders(): Map<String, String> {
        return mapOf(
            Http.Headers.AUTHORIZATION to API_KEY,
            Http.Headers.ACCEPT to "application/json",
        )
    }
}