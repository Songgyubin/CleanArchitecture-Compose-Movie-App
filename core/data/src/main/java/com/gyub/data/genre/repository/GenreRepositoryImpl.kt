package com.gyub.data.genre.repository

import com.gyub.data.genre.datasource.GenreDataSource
import com.gyub.data.genre.model.toEntity
import com.gyub.domain.genre.model.GenreEntity
import com.gyub.domain.genre.repository.GenreRepository
import javax.inject.Inject

/**
 * 장르 Repository 구현체
 *
 * @author   Gyub
 * @created  2024/04/14
 */
class GenreRepositoryImpl @Inject constructor(
    private val datasource: GenreDataSource
): GenreRepository {

    /**
     * 영화 장르 가져오기
     *
     * @return 영화 장르 리스트
     */
    override suspend fun getMovieGenres(): List<GenreEntity> {
        return datasource.getMovieGenres().map {
            it.toEntity()
        }
    }
}