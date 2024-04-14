package com.gyub.domain

import com.gyub.domain.movie.model.MovieListsEntity
import com.gyub.domain.movie.model.request.base.BasePageRequest
import com.gyub.domain.movie.repository.MovieListsRepository
import com.gyub.domain.movie.usecase.GetNowPlayingMovieListUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * 현재 상영 중인 영화 목록 UseCase Test
 *
 * @author   Gyub
 * @created  2024/03/05
 */
class GetNowPlayingMovieListUseCaseTest {

    // MockK로 MovieListsRepository 목 생성
    private val movieListsRepository: MovieListsRepository = mockk()

    // 테스트 대상인 GetNowPlayingMovieListUseCase
    private lateinit var getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase

    @Before
    fun setUp() {
        getNowPlayingMovieListUseCase = GetNowPlayingMovieListUseCase(movieListsRepository)
    }

    @Test
    fun `invoke calls getNowPlayingMovieList from repository`() = runBlocking {
        // 예상되는 반환값 설정
        val expected = flowOf(
            MovieListsEntity(
                page = null, results = listOf(), totalPages = 183, totalResults = 3658
            )
        )

        // MockK를 사용하여 예상 동작 설정
        coEvery { movieListsRepository.getNowPlayingMovieList(BasePageRequest()) } returns expected.first()

        // UseCase 실행
        val result = getNowPlayingMovieListUseCase.invoke(BasePageRequest()).filter { it.totalPages != null }.first()
        println(result)

        // 결과 검증
        assertEquals(expected.first().totalPages, result.totalPages)
        coVerify { movieListsRepository.getNowPlayingMovieList(BasePageRequest()) }
    }
}