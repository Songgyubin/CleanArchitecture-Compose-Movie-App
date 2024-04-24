package com.gyub.movieapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gyub.core.design.theme.GDSGray10
import com.gyub.core.design.theme.GDSGray40
import com.gyub.core.design.theme.GDSGreenGray60
import com.gyub.core.design.theme.GDSGreenGray90
import com.gyub.core.design.theme.GDSTypography
import com.gyub.movieapp.MainViewModel
import com.gyub.movieapp.MovieGenresUiState
import com.gyub.movieapp.R
import com.gyub.movieapp.model.GenreUiModel

/**
 * 장르 리스트
 *
 * @author   Gyub
 * @created  2024/04/14
 */
@Composable
fun GenreScreen(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val genresUiState: MovieGenresUiState by viewModel.movieGenres.collectAsStateWithLifecycle()
    val selectedGenreId: Int by viewModel.selectedGenreId.collectAsStateWithLifecycle()

    when (val state = genresUiState) {
        is MovieGenresUiState.Error -> {}
        is MovieGenresUiState.Loading -> {}
        is MovieGenresUiState.Success -> {
            val genreList = listOf(GenreUiModel(0, stringResource(R.string.all))) + state.data
            GenreList(genreList, selectedGenreId, viewModel::selectGenre)
        }
    }
}

@Composable
private fun GenreList(genres: List<GenreUiModel>, selectedGenreId: Int, onGenreSelected: (GenreUiModel) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(genres) { genre ->
            GenreChip(genre, genre.id == selectedGenreId) { onGenreSelected(genre) }
        }
    }
}

@Composable
private fun GenreChip(
    genre: GenreUiModel,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    InputChip(
        onClick = { onClick() },
        border = BorderStroke(1.5.dp, if (selected) GDSGray10 else GDSGreenGray90),
        label = {
            Text(
                text = genre.name,
                modifier = Modifier.padding(horizontal = 12.dp),
                style = GDSTypography.titleLarge,
                color = if (selected) GDSGray40 else GDSGreenGray60
            )
        },
        selected = selected
    )
}
