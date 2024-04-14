package com.gyub.network.model

/**
 * 장르 응답 모델
 *
 * @author   Gyub
 * @created  2024/04/14
 */
data class GenreResponse(
    val genres: List<Genre>?
)

data class Genre(
    val id: Int?,
    val name: String?
)
