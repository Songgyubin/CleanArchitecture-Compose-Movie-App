package com.gyub.network.retrofit

import com.gyub.network.const.ApiEndpoints.MOVIE
import com.gyub.network.const.Http
import com.gyub.network.model.MovieLists
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 *  영화 목록 Service
 *
 * @author   Gyub
 * @created  2024/03/02
 */
@JvmSuppressWildcards
interface MovieListsService {

    /**
     * 현재 극장에 상영 중인 영화 목록
     */
    @GET("${Http.ApiVersion.VERSION}${MOVIE}/now_playing")
    suspend fun getNowPlayingMovieList(@QueryMap request: Map<String, Any>): MovieLists

    /**
     * 인기순으로 정렬된 영화 목록
     */
    @GET("${Http.ApiVersion.VERSION}${MOVIE}/popular")
    suspend fun getPopularMovieList(): MovieLists

    /**
     * 등급별로 정렬된 영화 목록
     */
    @GET("${Http.ApiVersion.VERSION}${MOVIE}/top_rated")
    suspend fun getTopRatedMovieList(): MovieLists

    /**
     * 개봉 예정 중인 영화 목록
     */
    @GET("${Http.ApiVersion.VERSION}${MOVIE}/upcoming")
    suspend fun getUpcomingMovieList(): MovieLists
}