package com.gyub.movieapp.ui

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.gyub.core.design.theme.GDSRed10
import com.gyub.core.design.theme.GDSTypography
import com.gyub.movieapp.R
import kotlin.math.absoluteValue

/**
 *
 *
 * @author   Gyub
 * @created  2024/04/10
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieViewPager(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(
        initialPage = 3,
        pageCount = { 10 }
    )
    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        pageSpacing = 33.dp,
        contentPadding = PaddingValues(horizontal = 50.dp)
    ) { page ->
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
            Column {
                Text(
                    text = "Page: $page",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    style = GDSTypography.h4,
                    color = GDSRed10
                )

                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "sample",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieViewPagerPreview() {
    MovieViewPager()
}

const val PREVIOUS_PAGE_ROTATION = -7f
const val NEXT_PAGE_ROTATION = 7f