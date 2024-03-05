package com.gyub.domain.movies.model.request.base

/**
 * 기본 페이지 요청 모델
 *
 * @author   Gyub
 * @created  2024/03/05
 */
data class BasePageRequest(
    val language: String = "ko-KR",
    val page: Int = 1
)