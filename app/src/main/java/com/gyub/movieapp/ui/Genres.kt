package com.gyub.movieapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gyub.core.design.theme.GDSGray10
import com.gyub.core.design.theme.GDSGray40
import com.gyub.core.design.theme.GDSGreenGray90
import com.gyub.core.design.theme.GDSTypography

/**
 * 장르 리스트
 *
 * @author   Gyub
 * @created  2024/04/14
 */

@Composable
fun GenreList(
    genres: List<String> = listOf("액션", "호러", "스릴러", "액션", "호러", "스릴러", "액션", "호러", "스릴러", "액션", "호러", "스릴러")
) {
    LazyRow(
        contentPadding = PaddingValues(start = 32.dp, end = 32.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(genres) { genre ->
            GenreChip(genre)
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GenreChip(
    it: String,
    selected:Boolean = false
) {
    Chip(
        onClick = { },
        border = BorderStroke(1.5.dp, if (selected) GDSGray10 else GDSGreenGray90),
        colors = ChipDefaults.chipColors(
            backgroundColor = Color.White
        )
    ) {
        Text(
            text = it,
            modifier = Modifier.padding(horizontal = 12.dp),
            style = GDSTypography.subtitle2,
            color = GDSGray40
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GenreListPreview() {
    GenreList()
}
