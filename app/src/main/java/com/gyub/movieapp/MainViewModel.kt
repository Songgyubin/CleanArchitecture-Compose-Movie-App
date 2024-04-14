package com.gyub.movieapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyub.common.model.Result
import com.gyub.common.model.toResult
import com.gyub.domain.base.request.BasePageRequest
import com.gyub.domain.movie.usecase.GetNowPlayingMovieListUseCase
import com.gyub.movieapp.model.MovieListsUiModel
import com.gyub.movieapp.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
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
    getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase
) : ViewModel() {

    private var basePageRequest = BasePageRequest()

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
}

sealed interface NowPlayingMovieUiState {
    data object Loading : NowPlayingMovieUiState
    data object Error : NowPlayingMovieUiState
    data class Success(val data: MovieListsUiModel) : NowPlayingMovieUiState
}