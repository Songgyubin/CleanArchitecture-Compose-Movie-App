package com.gyub.network.model

/**
 * 영화 리스트 응답 모델
 *
 * @author   Gyub
 * @created  2024/03/02
 */
data class MovieLists(
    val page: Int,
    val results: List<Movie>
)

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val genreIds: List<Int>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val popularity: Double,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    val voteAverage: Double,
    val voteCount: Int
)