package com.gyub.movieapp.util.enums

/**
 * 영화 리스트 카테고리
 *
 * @author   Gyub
 * @created  2024/04/09
 */
enum class MovieListsCategory(val displayName: String) {
    NOW_PLAYING("상영 중"),
    POPULAR("인기순"),
    TOP_RATED("별점순"),
    UPCOMING("개봉 예정")
}