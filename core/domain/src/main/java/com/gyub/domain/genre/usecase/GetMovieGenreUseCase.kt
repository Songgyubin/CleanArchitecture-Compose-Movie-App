package com.gyub.domain.genre.usecase

import com.gyub.common.di.IoDispatcher
import com.gyub.domain.genre.model.GenreEntity
import com.gyub.domain.genre.repository.GenreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * 영화 장르 리스트 가져오기 UseCase
 *
 * @author   Gyub
 * @created  2024/04/14
 */
class GetMovieGenreUseCase @Inject constructor(
    private val repository: GenreRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<List<GenreEntity>> = flow {
        val item = repository.getMovieGenres()
        emit(item)
    }.flowOn(ioDispatcher)
}