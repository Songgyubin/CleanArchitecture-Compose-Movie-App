package com.gyub.data.datasource

import com.gyub.network.model.MovieLists
import com.gyub.network.retrofit.MovieListsService
import javax.inject.Inject

/**
 * 영화 목록 Data Source
 *
 * @author   Gyub
 * @created  2024/03/02
 */
class MovieListsDataSource
@Inject
constructor(private val movieListsService: MovieListsService) {

    /**
     * 현재 극장에 상영 중인 영화 목록
     */
    suspend fun getNowPlayingMovieList(): MovieLists {
        return movieListsService.getNowPlayingMovieList()
    }

    /**
     * 인기순으로 정렬된 영화 목록
     */
    suspend fun getPopularMovieList(): MovieLists {
        return movieListsService.getPopularMovieList()
    }

    /**
     * 등급별로 정렬된 영화 목록
     */
    suspend fun getTopRatedMovieList(): MovieLists {
        return movieListsService.getTopRatedMovieList()
    }

    /**
     * 개봉 예정 중인 영화 목록
     */
    suspend fun getUpcomingMovieList(): MovieLists {
        return movieListsService.getUpcomingMovieList()
    }
}