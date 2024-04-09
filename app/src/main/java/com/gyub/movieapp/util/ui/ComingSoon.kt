package com.gyub.movieapp.util.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gyub.core.design.theme.GDSGray30
import com.gyub.core.design.theme.GDSTypography
import com.gyub.movieapp.R
import kotlinx.coroutines.delay

/**
 * 구현되지 않는 기능 알림 화면
 *
 * @author   Gyub
 * @created  2024/04/09
 */

@Preview
@Composable
fun ComingSoonCircularTextPreview() {
    ComingSoonCircularText(visible = true, onVisibilityChange = {})
}

@Composable
fun ComingSoonCircularText(
    visible: Boolean,
    onVisibilityChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .background(GDSGray30, CircleShape)
                    .size(100.dp)
            ) {
                Text(
                    text = stringResource(R.string.coming_soon),
                    style = GDSTypography.caption,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        LaunchedEffect(visible) {
            if (visible) {
                delay(1000L)
                onVisibilityChange(false)
            }
        }
    }
}