package com.gyub.domain.movies.model

/**
 * Movie Entity
 *
 * @author   Gyub
 * @created  2024/02/22
 */
data class MovieEntity(
    val dates: DateRangeEntity,
    val page: Int,
    val results: List<ItemEntity>,
    val totalPages: Int,
    val totalResults: Int
) {
    data class DateRangeEntity(
        val maximum: String,
        val minimum: String
    )

    data class ItemEntity(
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
}
