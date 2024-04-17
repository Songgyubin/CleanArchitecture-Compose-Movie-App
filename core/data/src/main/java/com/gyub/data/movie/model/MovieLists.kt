package com.gyub.data.movie.model

import com.gyub.domain.movie.model.MovieListsEntity
import com.gyub.network.model.MovieLists

/**
 * Network Layer To Domain Layer
 *
 * @author   Gyub
 * @created  2024/03/05
 */
fun MovieLists.toEntity(): MovieListsEntity {
    return MovieListsEntity(
        dates = dates?.toEntity(),
        page = page,
        results = results?.map { movie ->
            MovieListsEntity.MovieEntity(
                adult = movie.adult,
                backdropPath = movie.backdropPath,
                genreIds = movie.genreIds,
                id = movie.id,
                originalLanguage = movie.originalLanguage,
                originalTitle = movie.originalTitle,
                overview = movie.overview,
                popularity = movie.popularity,
                posterPath = movie.posterPath,
                releaseDate = movie.releaseDate,
                title = movie.title,
                video = movie.video,
                voteAverage = movie.voteAverage,
                voteCount = movie.voteCount

            )
        },
        totalPages = totalPages,
        totalResults = totalResults
    )
}

/**
 * Mapper
 * [MovieLists.Dates] to [MovieListsEntity.DatesEntity]
 */
fun MovieLists.Dates.toEntity(): MovieListsEntity.DatesEntity {
    return MovieListsEntity.DatesEntity(
        max = this.max,
        min = this.min
    )
}