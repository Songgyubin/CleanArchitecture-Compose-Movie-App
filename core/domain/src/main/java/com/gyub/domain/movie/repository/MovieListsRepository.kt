package com.gyub.domain.movie.repository

import com.gyub.domain.movie.model.MovieListsEntity
import com.gyub.domain.base.request.BasePageRequest

/**
 * 영화 목록 Repository
 *
 * @author   Gyub
 * @created  2024/03/02
 */
interface MovieListsRepository {

    /**
     * 현재 극장에 상영 중인 영화 목록
     */
    suspend fun getNowPlayingMovieList(request: BasePageRequest): MovieListsEntity

    /**
     * 인기순으로 정렬된 영화 목록
     */
    suspend fun getPopularMovieList(): MovieListsEntity

    /**
     * 등급별로 정렬된 영화 목록
     */
    suspend fun getTopRatedMovieList(): MovieListsEntity

    /**
     * 개봉 예정 중인 영화 목록
     */
    suspend fun getUpcomingMovieList(): MovieListsEntity
}