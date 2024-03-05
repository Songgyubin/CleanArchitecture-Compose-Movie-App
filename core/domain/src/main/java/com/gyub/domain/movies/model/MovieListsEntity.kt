package com.gyub.domain.movies.model

/**
 * 영화 목록 Entiy
 *
 * @author   Gyub
 * @created  2024/02/22
 */
data class MovieListsEntity(
    val page: Int?,
    val results: List<MovieEntity>?
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
}