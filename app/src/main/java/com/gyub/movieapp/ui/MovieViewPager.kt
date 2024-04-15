package com.gyub.movieapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gyub.movieapp.MainViewModel
import com.gyub.movieapp.NowPlayingMovieUiState
import com.gyub.movieapp.model.MovieListsUiModel
import kotlin.math.absoluteValue

/**
 * 영화 포스터 및 기본 정보
 *
 * @author   Gyub
 * @created  2024/04/10
 */
@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val nowPlayingMovieUiState: NowPlayingMovieUiState by mainViewModel.nowPlayingMoviesState.collectAsStateWithLifecycle()
    val selectedGenreId: Int by mainViewModel.selectedGenreId.collectAsStateWithLifecycle()
    LaunchedEffect(key1 = null) {
        mainViewModel.fetchNowPlayingMovies(selectedGenreId)
    }

    when (val state = nowPlayingMovieUiState) {
        is NowPlayingMovieUiState.Loading -> {}
        is NowPlayingMovieUiState.Error -> {}
        is NowPlayingMovieUiState.Success -> {
            MovieViewPager(modifier, movies = state.data.results)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieViewPager(
    modifier: Modifier = Modifier,
    movies: List<MovieListsUiModel.MovieUiModel>
) {
    val pagerState = rememberPagerState(
        initialPage = movies.size / 2,
        pageCount = { movies.size }
    )

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        pageSpacing = 33.dp,
        contentPadding = PaddingValues(horizontal = 50.dp)
    ) { page ->
        Column {
            Card(
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(458.dp)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue

                        rotationZ = when {
                            page < pagerState.currentPage -> PREVIOUS_PAGE_ROTATION * pageOffset
                            page > pagerState.currentPage -> NEXT_PAGE_ROTATION * pageOffset
                            else -> 0f
                        }

                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
            ) {
                AsyncImage(
                    model = movies[page].posterPath, contentDescription = "Poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieViewPagerPreview() {
//    MovieViewPager()
}

const val PREVIOUS_PAGE_ROTATION = -7f
const val NEXT_PAGE_ROTATION = 7f