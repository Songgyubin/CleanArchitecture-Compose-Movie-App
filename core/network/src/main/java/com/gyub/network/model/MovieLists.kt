package com.gyub.network.model

import com.gyub.domain.movies.model.MovieListsEntity

/**
 * 영화 리스트 응답 모델
 *
 * @author   Gyub
 * @created  2024/03/02
 */
data class MovieLists(
    val dates: Dates? = null,
    val page: Int? = null,
    val results: List<Movie>? = null,
    val totalPages: Int? = null,
    val totalResults: Long? = null
) {
    data class Movie(
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

    data class Dates(
        val max: String?,
        val min: String?
    )
}