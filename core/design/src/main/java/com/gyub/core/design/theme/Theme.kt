package com.gyub.core.design.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColorScheme(
    primary = GDSRed30,
    secondary = GDSRed80,
    onPrimary = Color.White
)

private val LightColorPalette = lightColorScheme(
    primary = GDSWhite,
    secondary = GDSBlue80,
    onPrimary = Color.Black
)

@Composable
fun CleanArchitectureComposeMovieAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
//    val colorScheme = if (darkTheme) DarkColorPalette else LightColorPalette
    val colorScheme = LightColorPalette

    MaterialTheme(
        colorScheme = colorScheme,
        typography = GDSTypography,
        content = content
    )
}