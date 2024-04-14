package com.gyub.network.retrofit

import com.gyub.network.const.ApiEndpoints
import com.gyub.network.const.Http
import com.gyub.network.model.Genre
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 장르 리스트 Service
 *
 * @author   Gyub
 * @created  2024/04/14
 */
interface GenresService {

    @GET("${Http.ApiVersion.VERSION}${ApiEndpoints.GENRE}/movie/list")
    fun getMovieGenre(@Query("language") lan: String = "ko-KR") : List<Genre>
}