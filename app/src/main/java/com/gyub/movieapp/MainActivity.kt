package com.gyub.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gyub.domain.movies.model.MovieListsEntity
import com.gyub.domain.movies.model.request.base.BasePageRequest
import com.gyub.domain.movies.usecase.GetNowPlayingMovieListUseCase
import com.gyub.movieapp.ui.theme.CleanArchitectureComposeMovieAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MainViewModel by viewModels()
            CleanArchitectureComposeMovieAppTheme {
                MovieListScreen(viewModel)
            }
        }
    }
}

@Composable
fun MovieListScreen(viewModel: MainViewModel) {
    val movieListState = viewModel.movieListState.collectAsState()

    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            movieListState.value.results ?: return@LazyColumn
            items(movieListState.value.results.orEmpty()){ movie->
                MovieItem(movie)
            }
        }
    }
}

@Composable
fun MovieItem(movie: MovieListsEntity.MovieEntity) {
    // 각 영화에 대한 UI 구성
    Text(text = movie.title.orEmpty())
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNowPlayingMovieListUseCase: GetNowPlayingMovieListUseCase
) : ViewModel() {
    private val _movieListState = MutableStateFlow(MovieListsEntity())
    val movieListState: StateFlow<MovieListsEntity> = _movieListState.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        viewModelScope.launch {
            // UseCase를 실행하고 결과를 수집
            getNowPlayingMovieListUseCase(BasePageRequest()).collect { movies ->
                _movieListState.value = movies
            }
        }
    }
}