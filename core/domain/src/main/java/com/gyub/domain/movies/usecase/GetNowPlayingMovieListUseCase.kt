package com.gyub.domain.movies.usecase

import com.gyub.common.di.IoDispatcher
import com.gyub.domain.movies.model.MovieListsEntity
import com.gyub.domain.movies.model.request.base.BasePageRequest
import com.gyub.domain.movies.repository.MovieListsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * 현재 극장에 상영 중인 영화 목록 UseCase
 *
 * @author   Gyub
 * @created  2024/03/02
 */
class GetNowPlayingMovieListUseCase
@Inject
constructor(
    private val movieListsRepository: MovieListsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) {
    operator fun invoke(request: BasePageRequest): Flow<MovieListsEntity> = flow {
        val item = movieListsRepository.getNowPlayingMovieList(request)
        emit(item)
    }.catch {
        emit(MovieListsEntity())
    }.flowOn(ioDispatcher)
}