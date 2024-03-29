package com.gyub.movieapp.model

import com.gyub.common.util.extension.orDefault
import com.gyub.domain.movies.model.MovieListsEntity

/**
 * 영화 목록 UI Model
 *
 * @author   Gyub
 * @created  2024/03/18
 */
data class MovieListsUiModel(
    val dates: DatesUiModel = DatesUiModel(),
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

/**
 * [MovieListsEntity] to [MovieListsUiModel]
 */
fun MovieListsEntity.toUiModel(): MovieListsUiModel =
    MovieListsUiModel(
        dates = dates.toUiModel(),
        page = page.orDefault(),
        results = results?.map { it.toUiModel() }.orEmpty()
    )

/***
 * [MovieListsEntity.MovieEntity] to [MovieListsUiModel.MovieUiModel]
 */
fun MovieListsEntity.MovieEntity?.toUiModel(): MovieListsUiModel.MovieUiModel =
    MovieListsUiModel.MovieUiModel(
        id = this?.id.orDefault(),
        adult = this?.adult.orDefault(),
        genreIds = this?.genreIds.orEmpty(),
        overview = this?.overview.orEmpty(),
        posterPath = this?.posterPath.orEmpty(),
        releaseDate = this?.releaseDate.orEmpty(),
        title = this?.title.orEmpty(),
        voteAverage = this?.voteAverage.orDefault()
    )

/**
 * [MovieListsEntity.DatesEntity] to [MovieListsUiModel.DatesUiModel]
 */
fun MovieListsEntity.DatesEntity?.toUiModel(): MovieListsUiModel.DatesUiModel =
    MovieListsUiModel.DatesUiModel(
        max = this?.max.orEmpty(),
        min = this?.min.orEmpty()
    )