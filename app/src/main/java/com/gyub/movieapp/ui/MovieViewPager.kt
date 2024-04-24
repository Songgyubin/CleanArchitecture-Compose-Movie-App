package com.gyub.movieapp.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.gyub.common.util.extension.formatToSingleDecimal
import com.gyub.core.design.R.drawable
import com.gyub.core.design.theme.GDSGray10
import com.gyub.core.design.theme.GDSGray40
import com.gyub.core.design.theme.GDSTypography
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                shape = RoundedCornerShape(50.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
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
                    model = movies[page].getPosterUrl(), contentDescription = "Poster",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = movies[page].title,
                color = GDSGray10,
                style = GDSTypography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(9.dp))
            Row {
                Image(painter = painterResource(id = drawable.gds_icon_star), contentDescription = "Rating")
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = movies[page].voteAverage.formatToSingleDecimal(),
                    style = GDSTypography.titleMedium,
                    color = GDSGray40
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieViewPagerPreview() {
    MovieViewPager(
        movies = listOf(
            MovieListsUiModel.MovieUiModel(),
            MovieListsUiModel.MovieUiModel(),
            MovieListsUiModel.MovieUiModel(),
            MovieListsUiModel.MovieUiModel(),
            MovieListsUiModel.MovieUiModel(),
            MovieListsUiModel.MovieUiModel(),
        )
    )
}

const val PREVIOUS_PAGE_ROTATION = -7f
const val NEXT_PAGE_ROTATION = 7f