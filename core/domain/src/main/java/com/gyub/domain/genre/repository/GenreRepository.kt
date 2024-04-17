package com.gyub.domain.genre.repository

import com.gyub.domain.genre.model.GenreEntity

/**
 * 장르 Repository
 *
 * @author   Gyub
 * @created  2024/04/14
 */
interface GenreRepository {

    /**
     * 영화 장르 리스트 가져오기
     *
     * @return 영화 장르 리스트
     */
    suspend fun getMovieGenres(): List<GenreEntity>
}