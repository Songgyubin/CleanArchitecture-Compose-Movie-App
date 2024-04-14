package com.gyub.movieapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyub.common.model.Result
import com.gyub.common.model.toResult
import com.gyub.domain.base.request.BasePageRequest
import com.gyub.domain.genre.usecase.GetMovieGenreUseCase
import com.gyub.domain.movie.usecase.GetNowPlayingMovieListUseCase
import com.gyub.movieapp.model.GenreUiModel
import com.gyub.movieapp.model.MovieListsUiModel
import com.gyub.movieapp.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

/**
 * MainViewModel
 *
 * @author   Gyub
 * @created  2024/03/18
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase,
    getMovieGenreUseCase: GetMovieGenreUseCase
) : ViewModel() {

    private var basePageRequest = BasePageRequest()
    private val _selectedGenreId: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedGenreId = _selectedGenreId.asStateFlow()

    val movieGenres = getMovieGenreUseCase()
        .toResult()
        .map { result ->
            when (result) {
                is Result.Loading -> MovieGenresUiState.Loading
                is Result.Error -> MovieGenresUiState.Error
                is Result.Success -> {
                    delay(1000)
                    MovieGenresUiState.Success(result.data.map { it.toUiModel() })
                }
            }
        }
        .stateIn(
            viewModelScope,
            initialValue = MovieGenresUiState.Loading,
            started = SharingStarted.WhileSubscribed(5000)
        )

    val nowPlayingMovieListState = getNowPlayingMovieListUseCase(basePageRequest)
        .toResult()
        .map { result ->
            when (result) {
                is Result.Loading -> NowPlayingMovieUiState.Loading
                is Result.Error -> NowPlayingMovieUiState.Error
                is Result.Success -> NowPlayingMovieUiState.Success(result.data.toUiModel())
            }
        }
        .stateIn(
            viewModelScope,
            initialValue = MovieListsUiModel(),
            started = SharingStarted.WhileSubscribed(5000)
        )

    /**
     * 장르 선택
     *
     * @param genreUiModel
     */
    fun selectGenre(genreUiModel: GenreUiModel) {
        _selectedGenreId.value = genreUiModel.id
    }
}

sealed interface NowPlayingMovieUiState {
    data object Loading : NowPlayingMovieUiState
    data object Error : NowPlayingMovieUiState
    data class Success(val data: MovieListsUiModel) : NowPlayingMovieUiState
}

sealed interface MovieGenresUiState {
    data object Loading : MovieGenresUiState
    data object Error : MovieGenresUiState
    data class Success(val data: List<GenreUiModel>) : MovieGenresUiState
}