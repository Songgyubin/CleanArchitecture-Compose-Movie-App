package com.gyub.movieapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gyub.core.design.theme.GDSGray10
import com.gyub.core.design.theme.GDSGray30
import com.gyub.core.design.theme.GDSPink
import com.gyub.core.design.theme.GDSTypography
import com.gyub.movieapp.util.enums.MovieListsCategory

/**
 * 영화 목록 카테고리 리스트
 *
 * @author   Gyub
 * @created  2024/04/09
 */
@Composable
fun CategoryList(categories: List<MovieListsCategory>) {
    var selectedCategory by remember { mutableStateOf(categories.map { it.displayName }.first()) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 32.dp),
    ) {
        items(categories.map { it.displayName }) { category ->
            CategoryIndicatorText(
                categoryName = category,
                isSelected = selectedCategory == category
            ) { selectedCategory = category }
        }
    }
}

@Composable
fun CategoryIndicatorText(
    categoryName: String,
    isSelected: Boolean,
    onCategorySelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(end = 40.dp)
            .clickable {
                onCategorySelected(categoryName)
            }
    ) {
        Text(
            text = categoryName,
            style = GDSTypography.headlineLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            color = if (isSelected) GDSGray10 else GDSGray30
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (isSelected) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(6.dp)
                    .background(GDSPink, CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryListPreview() {
    CategoryList(categories = MovieListsCategory.entries)
}