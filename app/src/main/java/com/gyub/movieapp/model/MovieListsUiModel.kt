package com.gyub.movieapp.model

/**
 * 영화 목록 UI Model
 *
 * @author   Gyub
 * @created  2024/03/18
 */
data class MovieListsUiModel(
    val dates: DatesUiModel,
    val page: Int = 0,
    val results: List<MovieUiModel> = emptyList(),
) {
    data class MovieUiModel(
        val id: Int = -1,
        val adult: Boolean = false,
        val genreIds: List<Int> = emptyList(),
        val overview: String = "",
        val posterPath: String = "",
        val releaseDate: String = "",
        val title: String = "",
        val voteAverage: Double = 0.0,
    )

    data class DatesUiModel(
        val max: String = "",
        val min: String = ""
    )
}
