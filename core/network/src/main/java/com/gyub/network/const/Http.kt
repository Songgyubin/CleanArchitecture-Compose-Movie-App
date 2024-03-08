package com.gyub.network.const

/**
 * 헤더, URL, Server Status 등
 * Http 통신에 필요한 상수 정의
 *
 * @author   Gyub
 * @created  2024/02/29
 */
internal object Http {

    /**
     * Http Header
     */
    object Headers {
        const val AUTHORIZATION = "Authorization"
        const val ACCEPT = "Accept"
    }

    /**
     * Http Method
     */
    object Methods {
        const val POST = "POST"
        const val PUT = "PUT"
    }

    /**
     * Api Url
     */
    object Url {
        val BASE_URL: String by lazy { "https://api.themoviedb.org" }
    }

    /**
     * Api Version
     */
    object ApiVersion {
        const val VERSION = "3"
    }

    /**
     * Http Status
     */
    object Status {
        const val SUCCESS = 200
        const val SERVER_MAINTENANCE = 999
        const val BAD_REQUEST = 400
        const val TOKEN_ERROR = 401
        const val VALIDATE_ERROR = 403
        const val NOT_FOUND_ERROR = 404
        const val UPGRADE_ERROR = 426
        const val DUPLICATE_ERROR = 412
        const val NOT_FOUND = 404
    }
}