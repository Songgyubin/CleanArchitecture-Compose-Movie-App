package com.gyub.domain

import com.gyub.domain.base.request.BasePageRequest
import com.gyub.domain.genre.model.GenreEntity
import com.gyub.domain.genre.repository.GenreRepository
import com.gyub.domain.genre.usecase.GetMovieGenreUseCase
import com.gyub.domain.movie.model.MovieListsEntity
import com.gyub.domain.movie.repository.MovieListsRepository
import com.gyub.domain.movie.usecase.GetNowPlayingMovieListUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * 영화 장르 가져오는 UseCase Test
 *
 * @author   Gyub
 * @created  2024/04/14
 */
class GetMovieGenreUseCaseTest {

    // MockK로 MovieListsRepository 목 생성
    private val genreRepository: GenreRepository = mockk()

    // 테스트 대상인 GetNowPlayingMovieListUseCase
    private lateinit var getMovieGenresUseCase: GetMovieGenreUseCase

    @Before
    fun setUp() {
        getMovieGenresUseCase = GetMovieGenreUseCase(genreRepository, Dispatchers.Unconfined)
    }

    @Test
    fun `invoke calls getNowPlayingMovieList from repository`() = runBlocking {
        // 예상되는 반환값 설정
        val expected = flowOf(
            listOf(
                GenreEntity(
                    id = 28, name = "Action"
                )
            )
        )

        // MockK를 사용하여 예상 동작 설정
        coEvery { genreRepository.getMovieGenres() } returns expected.first()

        // UseCase 실행
        val result = getMovieGenresUseCase.invoke().first()
        println(result)

        // 결과 검증
        TestCase.assertEquals(expected.first().first(), result.first())
    }
}