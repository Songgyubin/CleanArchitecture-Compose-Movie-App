package com.gyub.data.genre.datasource

import com.gyub.network.model.Genre
import com.gyub.network.retrofit.GenresService
import javax.inject.Inject

/**
 * 장르 DataSource
 *
 * @author   Gyub
 * @created  2024/04/14
 */
class GenreDataSource @Inject constructor(
    private val genresService: GenresService
) {
    /**
     * 영화 장르 리스트 가져오기
     *
     * @return 영화 장르 리스트
     */
    fun getMovieGenres(): List<Genre> {
        return genresService.getMovieGenre()
    }
}