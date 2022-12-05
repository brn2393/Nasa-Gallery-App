package com.obvious.nasagalleryapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColorScheme(
    primary = BlueGrey700,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White,
    secondary = BlueGrey500,
    onSecondary = Color.White,
    onSecondaryContainer = Color.White,
    tertiary = BlueGrey200,
    onTertiary = Color.White,
    onTertiaryContainer = Color.White,
    background = BlueGrey700
)

private val LightColorPalette = lightColorScheme(
    primary = BlueGrey700,
    onPrimary = Color.White,
    onPrimaryContainer = Color.White,
    secondary = BlueGrey500,
    onSecondary = Color.White,
    onSecondaryContainer = Color.White,
    tertiary = BlueGrey200,
    onTertiary = Color.White,
    onTertiaryContainer = Color.White,
    background = Color.White
)

@Composable
fun NASAGalleryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = !darkTheme
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}