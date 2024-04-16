package com.gyub.network.model

import com.google.gson.annotations.SerializedName

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
    @SerializedName("total_pages")
    val totalPages: Int? = null,
    @SerializedName("total_results")
    val totalResults: Long? = null
) {
    data class Movie(
        val adult: Boolean?,
        @SerializedName("backdrop_path")
        val backdropPath: String?,
        @SerializedName("genre_ids")
        val genreIds: List<Int>?,
        val id: Int?,
        @SerializedName("original_language")
        val originalLanguage: String?,
        @SerializedName("original_title")
        val originalTitle: String?,
        val overview: String?,
        val popularity: Double?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        val title: String?,
        val video: Boolean?,
        @SerializedName("vote_average")
        val voteAverage: Double?,
        @SerializedName("vote_count")
        val voteCount: Int?
    )

    data class Dates(
        val max: String?,
        val min: String?
    )
}