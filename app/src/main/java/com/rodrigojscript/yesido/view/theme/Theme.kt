package com.rodrigojscript.yesido.view.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = primaryDark,
    background = backgroundDark,
    surface = primaryDark,
    onPrimary = textDark,
    onSecondary = textDark,
    onBackground = textDark,
    onSurface = textDark,
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = primaryLight,
    background = backgroundLight,
    surface = primaryLight,
    onPrimary = textLight,
    onSecondary = textLight,
    onBackground = textLight,
    onSurface = textLight,
    /*Other default colors to override
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun YesIDoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors, typography = Typography, shapes = Shapes, content = content
    )
}