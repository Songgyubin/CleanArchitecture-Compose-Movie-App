package com.gyub.domain.movies.usecase

import com.gyub.domain.movies.model.MovieListsEntity
import com.gyub.domain.movies.repository.MovieListsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * 현재 극장에 상영 중인 영화 목록 UseCase
 *
 * @author   Gyub
 * @created  2024/03/02
 */
class GetNowPlayingMovieListUseCase
@Inject
constructor(private val movieListsRepository: MovieListsRepository) {
    operator fun invoke(): Flow<MovieListsEntity> = flow {
        val item = movieListsRepository.getNowPlayingMovieList()
        emit(item)
    }
}