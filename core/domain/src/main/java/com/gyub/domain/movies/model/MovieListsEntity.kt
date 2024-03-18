package com.gyub.domain.movies.model

/**
 * 영화 목록 Entiy
 *
 * @author   Gyub
 * @created  2024/02/22
 */
data class MovieListsEntity(
    val dates: DatesEntity? = null,
    val page: Int? = null,
    val results: List<MovieEntity>? = null,
    val totalPages: Int? = null,
    val totalResults: Long? = null
) {
    data class MovieEntity(
        val adult: Boolean?,
        val backdropPath: String?,
        val genreIds: List<Int>?,
        val id: Int?,
        val originalLanguage: String?,
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        val posterPath: String?,
        val releaseDate: String?,
        val title: String?,
        val video: Boolean?,
        val voteAverage: Double?,
        val voteCount: Int?
    )

    data class DatesEntity(
        val max: String?,
        val min: String?
    )
}