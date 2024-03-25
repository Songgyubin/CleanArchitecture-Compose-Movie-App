package com.gyub.movieapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyub.domain.movies.model.request.base.BasePageRequest
import com.gyub.domain.movies.usecase.GetNowPlayingMovieListUseCase
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
        .map { it.toUiModel() }
        .stateIn(
            viewModelScope,
            initialValue = MovieListsUiModel(),
            started = SharingStarted.WhileSubscribed(5000)
        )
}