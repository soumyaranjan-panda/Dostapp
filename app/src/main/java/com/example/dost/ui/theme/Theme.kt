package com.example.dost.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.dost.R

private val DarkColorPalette = darkColors(
    background = Color(0xff9F6632),
    surface = Color(0xffFCF6EF),
    onPrimary = Color(0xffE7B482),
    onSecondary = Color(0xff425A27),
    onBackground = Color(0xffFCF6EF),
    onSurface = Color(0xffECE6E2),
)

private val LightColorPalette = lightColors(
    background = Color(0xff9F6632),
    surface = Color(0xffFCF6EF),
    onPrimary = Color(0xffE7B482),
    onSecondary = Color(0xff425A27),
    onBackground = Color(0xffFCF6EF),
    onSurface = Color(0xffECE6E2),

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
fun DostTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
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