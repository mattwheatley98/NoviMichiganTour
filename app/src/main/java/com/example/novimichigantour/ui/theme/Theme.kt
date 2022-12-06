package com.example.novimichigantour.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = md_theme_dark_primary,
    secondary = md_theme_dark_secondary,
    surface = md_theme_dark_surface,
    background = md_theme_dark_background,
    onPrimary = md_theme_dark_onPrimary,
    onSurface = md_theme_dark_onSurface
)

private val LightColorPalette = lightColors(
    primary = md_theme_light_primary,
    secondary = md_theme_light_secondary,
    surface = md_theme_light_surface,
    background = md_theme_light_background,
    onPrimary = md_theme_light_onPrimary,
    onSurface = md_theme_light_onSurface

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun NoviMichiganTourTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}