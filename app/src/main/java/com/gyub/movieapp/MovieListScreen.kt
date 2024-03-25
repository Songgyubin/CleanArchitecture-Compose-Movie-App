package com.gyub.movieapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gyub.movieapp.model.MovieListsUiModel

/**
 * 영화 목록 화면
 *
 * @author   Gyub
 * @created  2024/03/18
 */

@Composable
fun MovieList(
    viewModel: MainViewModel = hiltViewModel()
) {
    val movieListState = viewModel.nowPlayingMovieListState.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(movieListState.value.results, key = { movie -> movie.id }) {
            MovieCard(movie = it)
        }
    }
}

@Composable
fun MovieCard(movie: MovieListsUiModel.MovieUiModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column {
            Text(text = movie.title)
            Spacer(modifier = Modifier.padding(16.dp))
            Text(text = movie.voteAverage.toString())
        }
    }
}