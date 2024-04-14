package com.gyub.data.movie.repository

import com.gyub.data.movie.datasource.MovieListsDataSource
import com.gyub.data.movie.model.toEntity
import com.gyub.domain.movie.model.MovieListsEntity
import com.gyub.domain.base.request.BasePageRequest
import com.gyub.domain.movie.repository.MovieListsRepository
import javax.inject.Inject

/**
 * 영화 목록 Repository 구현체
 *
 * @author   Gyub
 * @created  2024/03/04
 */
class MovieListsRepositoryImpl
@Inject constructor(
    private val dataSource: MovieListsDataSource
) : MovieListsRepository {

    /**
     * 현재 극장에 상영 중인 영화 목록
     */
    override suspend fun getNowPlayingMovieList(request: BasePageRequest): MovieListsEntity {
        return dataSource.getNowPlayingMovieList(request).toEntity()
    }

    /**
     * 인기순으로 정렬된 영화 목록
     */
    override suspend fun getPopularMovieList(): MovieListsEntity {
        return dataSource.getPopularMovieList().toEntity()
    }

    /**
     * 등급별로 정렬된 영화 목록
     */
    override suspend fun getTopRatedMovieList(): MovieListsEntity {
        return dataSource.getTopRatedMovieList().toEntity()
    }

    /**
     * 개봉 예정 중인 영화 목록
     */
    override suspend fun getUpcomingMovieList(): MovieListsEntity {
        return dataSource.getUpcomingMovieList().toEntity()
    }
}