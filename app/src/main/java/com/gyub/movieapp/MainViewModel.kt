package com.gyub.movieapp

import androidx.lifecycle.ViewModel
import com.gyub.domain.movies.usecase.GetNowPlayingMovieListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * MainViewModel
 *
 * @author   Gyub
 * @created  2024/03/18
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase
) : ViewModel() {


}